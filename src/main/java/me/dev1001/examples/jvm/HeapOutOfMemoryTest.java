package me.dev1001.examples.jvm;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author hongzong.li
 */
public class HeapOutOfMemoryTest {
    public static void main(String[] args) {
        List<byte[]> allocated = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
           allocated.add(new byte[1 * 1024 * 1024]);
        }
        System.out.println("The end");
    }
}
