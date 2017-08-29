package me.dev1001.examples.jvm;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hongzong.li
 */
public class TooManyThreadsTest {

    private static final int MAX_THREAD_COUNT = 10000;

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger(0);
        CountDownLatch barrier = new CountDownLatch(1);
        for (int i = 0; i < MAX_THREAD_COUNT; i++) {
            new Thread(() -> {
                System.out.println(count.incrementAndGet() + " threads are created");
                Uninterruptibles.awaitUninterruptibly(barrier);
            }).start();
        }
        barrier.countDown();
    }
}
