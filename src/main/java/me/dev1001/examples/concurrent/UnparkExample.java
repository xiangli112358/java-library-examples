package me.dev1001.examples.concurrent;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author hongzong.li
 */
public class UnparkExample {

  /**
   * This example demonstrate that unpark can be invoked before park, if so, the thread will run
   * immediately and will not wait for a permit.
   */
  public static void main(String[] args) {
    Thread t = new Thread(
        () -> {
          Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
          System.out.println("Thread" + Thread.currentThread().getName() + " is parking...");
          LockSupport.park();
          System.out.println("Thread " + Thread.currentThread().getName() + " unparked");
        }
    );
    t.start();
    LockSupport.unpark(t);
    Uninterruptibles.sleepUninterruptibly(6, TimeUnit.SECONDS);
  }
}
