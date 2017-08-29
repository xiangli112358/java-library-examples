package me.dev1001.examples.lang;

/**
 * @author hongzong.li
 *
 * Changing control flow in finally block will make code hard to understand.
 * The ways of changing control flow include return, throw, contiue and break.
 */
public class ChangeControlFlowInFinallyBlock {
  public static void main(String[] args) {
    System.out.println(overrideResultWithReturn());
  }

  private static int overrideResultWithReturn() {
    try {
      return 0;
    } finally {
      return 1;
    }
  }
}
