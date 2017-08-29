package me.dev1001.examples.jvm;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

/**
 * @author hongzong.li
 */
public class TaskThreadDumpWIthKill {
    public static void main(String[] args) {
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.MINUTES);
    }
}
