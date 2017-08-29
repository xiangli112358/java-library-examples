package me.dev1001.examples.junit;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

/**
 * @author hongzong.li
 */
public class UserTest {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                m();
            }
        }).start();
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.MINUTES);
    }

    public static void m() {
        new Throwable().printStackTrace();
    }
}
