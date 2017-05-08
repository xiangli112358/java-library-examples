package me.dev1001.examples.lock;

import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.CountDownLatch;

/**
 * Created by hongzong.li on 5/8/17.
 */
public class DeadLockExample {

  public static void main(String[] args) {
    CountDownLatch latch = new CountDownLatch(1);

    Object lock1 = new Object();
    Object lock2 = new Object();

    Thread t1 = new Thread(() -> {
      synchronized (lock1) {
        System.out.println(Thread.currentThread().getName() + " got lock1");
        Uninterruptibles.awaitUninterruptibly(latch);
        synchronized (lock2) {
          System.out.println(Thread.currentThread().getName() + "got lock2");
        }
      }
    });

    Thread t2 = new Thread(() -> {
      synchronized (lock2) {
        System.out.println(Thread.currentThread().getName() + " got lock2");
        Uninterruptibles.awaitUninterruptibly(latch);
        synchronized (lock1) {
          System.out.println(Thread.currentThread().getName() + "got lock1");
        }
      }
    });

    t1.start();
    t2.start();
    latch.countDown();

    Uninterruptibles.joinUninterruptibly(t1);
    Uninterruptibles.joinUninterruptibly(t2);

  }
}
