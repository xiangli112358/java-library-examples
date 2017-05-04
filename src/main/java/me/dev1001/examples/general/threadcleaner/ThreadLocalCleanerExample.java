package me.dev1001.examples.general.threadcleaner;

import java.text.*;

/**
 * Created by hongzong.li on 4/28/17.
 */


public class ThreadLocalCleanerExample {
  private static final ThreadLocal<DateFormat> df =
      ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

  public static void main(String... args) {
    System.out.println("First ThreadLocalCleaner context");
    try (ThreadLocalCleaner tlc = new ThreadLocalCleaner(
        ThreadLocalChangeListener.PRINTER)) {
      System.out.println(System.identityHashCode(df.get()));
      System.out.println(System.identityHashCode(df.get()));
      System.out.println(System.identityHashCode(df.get()));
    }

    System.out.println("Another ThreadLocalCleaner context");
    try (ThreadLocalCleaner tlc = new ThreadLocalCleaner(
        ThreadLocalChangeListener.PRINTER)) {
      System.out.println(System.identityHashCode(df.get()));
      System.out.println(System.identityHashCode(df.get()));
      System.out.println(System.identityHashCode(df.get()));
    }
  }
}
