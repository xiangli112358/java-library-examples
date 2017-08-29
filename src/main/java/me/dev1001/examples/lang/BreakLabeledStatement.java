package me.dev1001.examples.lang;

/**
 * @author hongzong.li
 *
 * This example demonstrate that you can break a if-else block with the 'break label' statement.
 */
public class BreakLabeledStatement {

  public static void main(String[] args) {
    boolean shouldAbort = true;
    label:
    {
      System.out.println("In label statement block");
      if (shouldAbort) {
        break label;
      }
      System.out.println("Unreachable statement");
    }
  }
}
