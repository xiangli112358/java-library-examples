package me.dev1001.examples.general.threadcleaner;

/**
 * Created by hongzong.li on 4/28/17.
 */
@FunctionalInterface
public interface ThreadLocalChangeListener {
  void changed(Mode mode, Thread thread, ThreadLocal<?> threadLocal, Object value);

  ThreadLocalChangeListener EMPTY = (m, t, tl, v) -> {};

  ThreadLocalChangeListener PRINTER =
      (m, t, tl, v) -> System.out.printf(
          "Thread %s %s ThreadLocal %s with value %s%n",
          t, m, tl.getClass(), v);

  enum Mode {
    ADDED, REMOVED
  }
}
