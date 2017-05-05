package me.dev1001.examples.utils.concurrent;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class StripedExecutorServiceExample {

  private static final int UPTO = 10;

  public static void main(String[] args) throws InterruptedException {
    test(new StripedExecutorService());
    test(Executors.newCachedThreadPool());
  }

  private static void test(ExecutorService pool)
      throws InterruptedException {
    final Vector<Integer> call_sequence = new Vector<>();
    for (int i = 0; i < UPTO; i++) {
      final int tempI = i;
      pool.submit(new StripedCallable<Void>() {
        public Void call() throws Exception {
          TimeUnit.MILLISECONDS.sleep(
              ThreadLocalRandom.current().nextInt(2, 10)
          );
          call_sequence.add(tempI);
          return null;
        }

        public Object getStripe() {
          return call_sequence;
        }
      });
    }
    pool.shutdown();
    while (!pool.awaitTermination(1, TimeUnit.SECONDS)) {
      ;
    }
    System.out.println(call_sequence);
  }
}