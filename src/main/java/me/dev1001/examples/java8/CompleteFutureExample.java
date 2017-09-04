package me.dev1001.examples.java8;


import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author hongzong.li
 */
public class CompleteFutureExample {

    public static void main(String[] args) {

        Executor executor = Executors.newCachedThreadPool();
        Holder holder = new Holder();
        holder.exceptionHandler = (ExceptionHandler<Throwable>) t -> holder.combine.cancel(true);

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
            try {
                throw new RuntimeException("exception");
            } catch (Throwable t) {
                holder.exceptionHandler.handleException(t);
            }
            return null;
        }, executor);
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
            holder.result2 = "task2";
            return "task2";
        }, executor);

        CompletableFuture<Void> combine = CompletableFuture.allOf(future1, future2);
        holder.combine = combine;


        combine.thenAccept((Void) -> {
                System.out.println(holder.result1);
                System.out.println(holder.result2);
            }

        );
        System.out.println("not need wait for 4 secs");
    }


    private static class Holder {
        String result1;
        String result2;
        CompletableFuture<?> combine;
        ExceptionHandler<?> exceptionHandler;

    }

    interface ExceptionHandler<E extends Throwable> {
        void handleException(Throwable t);
    }
}
