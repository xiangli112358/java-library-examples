package me.dev1001.examples.guava.cache;


import static com.sun.corba.se.impl.util.RepositoryId.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.TimeUnit;

/**
 * @author think on 30/3/2018
 */
public class AutoRefreshExample {

  public static void main(String[] args) {
    LoadingCache<String, String> cache = CacheBuilder.newBuilder()
        .refreshAfterWrite(1, TimeUnit.SECONDS)
        .build(new CacheLoader<String, String>() {
          @Override
          public String load(String key) throws Exception {
            Uninterruptibles.sleepUninterruptibly(700, TimeUnit.MILLISECONDS);
            return key;
          }
        });

    cache.put("test", "test");

    for (int i = 0; i < 100; i++) {
      long start = System.currentTimeMillis();
      cache.getUnchecked("test");
      System.out.println(i + ": " + (System.currentTimeMillis() - start));
      Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
    }

  }
}
