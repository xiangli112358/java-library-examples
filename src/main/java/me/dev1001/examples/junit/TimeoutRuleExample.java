package me.dev1001.examples.junit;

import com.google.common.util.concurrent.Uninterruptibles;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author hongzong.li
 */
public class TimeoutRuleExample {

    @Test(timeout = 2000)
    public void testTimeout() {
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }


}
