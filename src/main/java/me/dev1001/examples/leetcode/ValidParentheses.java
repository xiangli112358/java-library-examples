package me.dev1001.examples.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by hongzong.li on 5/31/17.
 */
public class ValidParentheses {
  public static boolean isValidParentheses(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (isLeftParenthese(ch)) {
        stack.offerLast(ch);
      } else if (!stack.isEmpty() && isParenthese(stack.pollLast(), ch)) {
        // do nothing
      } else {
        return false;
      }
    }
    return stack.isEmpty();
  }

  private static boolean isParenthese(char left, char right) {
    return (left == '(' && right == ')') ||
        (left == '[' && right == ']') ||
        (left == '{' && right == '}');
  }

  private static boolean isLeftParenthese(char ch) {
    return ch == '(' || ch == '[' || ch == '{';
  }

  public static void main(String[] args) {
    String s = "(()[](({})))";
    System.out.println(isValidParentheses(s));
  }
}
