package me.dev1001.examples.caffeine;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.TimeUnit;

/**
 * @author think on 30/3/2018
 */
public class AutoRefreshExample {

  public static void main(String[] args) {
    LoadingCache<String, String> cache = Caffeine.newBuilder()
        .refreshAfterWrite(1, TimeUnit.SECONDS)
        .build(s -> {
          Uninterruptibles.sleepUninterruptibly(700, TimeUnit.MILLISECONDS);
          return s;
        });

    cache.put("test", "test");

    for (int i = 0; i < 100; i++) {
      long start = System.currentTimeMillis();
      cache.get("test");
      System.out.println(i + ": " + (System.currentTimeMillis() - start));
      Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }

  }
}
