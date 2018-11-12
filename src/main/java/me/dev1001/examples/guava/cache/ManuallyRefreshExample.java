package me.dev1001.examples.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author think on 30/3/2018
 */
public class ManuallyRefreshExample {

  private static final ScheduledExecutorService executor =
      Executors.newSingleThreadScheduledExecutor();

  public static void main(String[] args) {
    LoadingCache<String, String> cache = CacheBuilder.newBuilder()
        .build(new CacheLoader<String, String>() {
          @Override
          public String load(String s) {
            Uninterruptibles.sleepUninterruptibly(700, TimeUnit.MILLISECONDS);
            return s;
          }
        });
    executor.scheduleAtFixedRate(() -> cache.refresh("test"), 0, 1, TimeUnit.SECONDS);

    for (int i = 0; i < 1000; i++) {
      long start = System.currentTimeMillis();
      cache.getUnchecked("test");
      System.out.println(i + ": " + (System.currentTimeMillis() - start));
      Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
    }
  }
}
