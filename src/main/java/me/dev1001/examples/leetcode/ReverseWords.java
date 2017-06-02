package me.dev1001.examples.leetcode;

/**
 * Created by hongzong.li on 6/1/17.
 */
public class ReverseWords {

  public static String reverseWords(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }

    String[] words = s.split(" ");
    StringBuilder result = new StringBuilder(s.length());
    for (int i = words.length - 1; i > 0; i--) {
      result.append(words[i]).append(" ");
    }
    result.append(words[0]);
    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(reverseWords("the sky is blue"));
  }
}
