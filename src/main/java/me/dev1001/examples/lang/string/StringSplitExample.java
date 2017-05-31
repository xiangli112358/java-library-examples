package me.dev1001.examples.lang.string;

import com.google.common.base.Splitter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hongzong.li on 5/25/17.
 */
public class StringSplitExample {

  public static void main(String[] args) {
    String toSplit = "A, B,C, D";

    String[] alphas = toSplit.split("\\s*,\\s*");
    System.out.println(Arrays.toString(alphas));

    List<String> alphaList = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(toSplit);
    System.out.println(alphaList);
  }
}
