package me.dev1001.examples.lang.string;

import com.google.common.base.Joiner;

/**
 * Created by hongzong.li on 5/25/17.
 */
public class StringJoinExample {

  public static void main(String[] args) {
    String[] alphas = new String[] {"a", "b", "c", "d"};
    System.out.println(String.join(",", alphas));
    System.out.println(Joiner.on(",").join(alphas));
  }

}
