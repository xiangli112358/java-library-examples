package me.dev1001.examples.utils.concurrent;

/**
 * Created by hongzong.li on 5/10/17.
 */

import java.util.Objects;
import java.util.concurrent.locks.Lock;

/**
 * A wrapper of lock which can unlock itself automatically by using try-with-resource mechanism.
 */
public class AutoLock implements AutoCloseable {
  private final Lock lock;

  public AutoLock(Lock lock) {
    this.lock = Objects.requireNonNull(lock);
    lock.lock();
  }

  @Override
  public void close() {
    lock.unlock();
  }
}
