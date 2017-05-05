package me.dev1001.examples.utils.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by hongzong.li on 5/5/17.
 */
public class CountingCompletionService<V> extends ExecutorCompletionService<V> {

  private final AtomicLong submittedTasks = new AtomicLong();
  private final AtomicLong completedTasks = new AtomicLong();

  public CountingCompletionService(Executor executor) {
    super(executor);
  }

  public CountingCompletionService(
      Executor executor, BlockingQueue<Future<V>> queue) {
    super(executor, queue);
  }

  public Future<V> submit(Callable<V> task) {
    Future<V> future = super.submit(task);
    submittedTasks.incrementAndGet();
    return future;
  }

  public Future<V> submit(Runnable task, V result) {
    Future<V> future = super.submit(task, result);
    submittedTasks.incrementAndGet();
    return future;
  }

  public Future<V> take() throws InterruptedException {
    Future<V> future = super.take();
    completedTasks.incrementAndGet();
    return future;
  }

  public Future<V> poll() {
    Future<V> future = super.poll();
    if (future != null) {
      completedTasks.incrementAndGet();
    }
    return future;
  }

  public Future<V> poll(long timeout, TimeUnit unit)
      throws InterruptedException {
    Future<V> future = super.poll(timeout, unit);
    if (future != null) {
      completedTasks.incrementAndGet();
    }
    return future;
  }

  public long getNumberOfCompletedTasks() {
    return completedTasks.get();
  }

  public long getNumberOfSubmittedTasks() {
    return submittedTasks.get();
  }

  public boolean hasUncompletedTasks() {
    return completedTasks.get() < submittedTasks.get();
  }
}
