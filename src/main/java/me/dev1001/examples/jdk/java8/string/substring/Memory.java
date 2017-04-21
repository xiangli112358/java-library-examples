package me.dev1001.examples.jdk.java8.string.substring;

import java.lang.management.ManagementFactory;
import javax.management.ObjectName;

/**
 * Created by hongzong.li on 4/20/17.
 */

public class Memory {

  public static long threadAllocatedBytes() {
    try {
      return (Long) ManagementFactory.getPlatformMBeanServer()
          .invoke(
              new ObjectName(
                  ManagementFactory.THREAD_MXBEAN_NAME),
              "getThreadAllocatedBytes",
              new Object[]{Thread.currentThread().getId()},
              new String[]{long.class.getName()}
          );
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }
}
