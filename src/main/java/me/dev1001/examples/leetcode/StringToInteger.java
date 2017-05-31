package me.dev1001.examples.leetcode;

import java.util.Objects;

/**
 * Created by hongzong.li on 5/31/17.
 */
public class StringToInteger {

  public static int atoi(String s) {
    Objects.requireNonNull(s);
    s = s.trim();
    if (s.isEmpty()) {
      throw new IllegalArgumentException("empty string");
    }

    boolean positive = true;
    int start = 0;
    if (s.charAt(0) == '-') {
      positive = false;
    } else if (s.charAt(0) == '+') {
      start = 1;
    }

    double result = 0;
    for (int i = start; i < s.length(); i++) {
      result = 10 * result + (s.charAt(i) - '0');
    }

    result = positive ? result : -result;

    if (result > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }
    if (result < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }
    return (int) result;
  }
}
