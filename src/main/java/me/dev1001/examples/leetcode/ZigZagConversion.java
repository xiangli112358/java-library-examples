package me.dev1001.examples.leetcode;

/**
 * Created by hongzong.li on 6/1/17.
 */
public class ZigZagConversion {

  public static String convert(String s, int rows) {
    if (rows == 1) {
      return s;
    }

    int step = 2 * rows - 2;
    StringBuilder result = new StringBuilder(s.length());
    for (int i = 0; i < rows; i++) {
      if (i == 0 || i == rows - 1) {
        for (int j = i; j < s.length(); j += step) {
          result.append(s.charAt(j));
        }
      } else {
        int step1 = step - 2 * i;
        int step2 = step - step1;
        boolean flag = true;
        int j = i;
        while (j < s.length()) {
          result.append(s.charAt(j));
          if (flag) {
            j += step1;
          } else {
            j += step2;
          }
          flag = !flag;
        }
      }
    }
    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(convert("PAYPALISHIRING", 3));
    System.out.println(convert("PAYPALISHIRING", 4));
  }
}
