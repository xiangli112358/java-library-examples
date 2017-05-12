package me.dev1001.examples.utils.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hongzong.li on 5/10/17.
 */
public class AutoLockExample {

  private static long num = 0;

  public static void main(String[] args) throws InterruptedException {
    ReentrantLock lock = new ReentrantLock();
    ExecutorService executor = Executors.newFixedThreadPool(100);

    for (int j = 0; j < 10000; j++) {
      executor.submit(() -> {
        try (AutoLock ignored = new AutoLock(lock)) {
          num++;
        }
      });
    }

    executor.shutdown();
    executor.awaitTermination(1, TimeUnit.SECONDS);
    executor.shutdownNow();

    System.out.println(num);

  }

}
