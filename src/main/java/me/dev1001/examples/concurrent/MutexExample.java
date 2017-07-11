package me.dev1001.examples.concurrent;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

/**
 * @author hongzong.li
 */
public class MutexExample {
  public static void main(String[] args) {
    Mutex mutex = new Mutex();
    final ValueHolder valueHolder = new ValueHolder(0);

    System.out.println(mutex.isLocked());
    mutex.lock();
    System.out.println(mutex.isLocked());
    try {
      for (int i = 0; i < 10; i++) {
        new Thread(() -> {
          mutex.lock();
          try {
            valueHolder.inc();
          } finally {
            mutex.unlock();
          }
        }).start();
      }
    } finally {
      mutex.unlock();
    }

    Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    System.out.println(valueHolder.getVal());
  }

  private static class ValueHolder {
    int val;

    public ValueHolder(int val) {
      this.val = val;
    }

    public void inc() {
      val++;
    }

    public int getVal() {
      return val;
    }
  }

}
