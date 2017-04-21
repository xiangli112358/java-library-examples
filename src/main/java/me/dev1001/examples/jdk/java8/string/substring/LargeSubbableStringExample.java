package me.dev1001.examples.jdk.java8.string.substring;

import java.util.Arrays;

/**
 * Created by hongzong.li on 4/20/17.
 */
public class LargeSubbableStringExample {

  public static void main(String... args) {
    char[] largeText = new char[10000000];
    Arrays.fill(largeText, 'A');
    CharSequence superString = new SubbableString(largeText);

    long bytes = Memory.threadAllocatedBytes();
    CharSequence[] subStrings = new CharSequence[
        largeText.length / 1000];
    for (int i = 0; i < subStrings.length; i++) {
      subStrings[i] = superString.subSequence(
          i * 1000, i * 1000 + 1000);
    }
    bytes = Memory.threadAllocatedBytes() - bytes;
    System.out.printf("%,d%n", bytes);
  }
}
