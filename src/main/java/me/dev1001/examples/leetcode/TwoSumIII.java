package me.dev1001.examples.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hongzong.li on 5/31/17.
 */
public class TwoSumIII {

  private static class TwoSum {

    private Map<Integer, Integer> numbersMap = new HashMap<>();

    public void add(int number) {
      if (numbersMap.containsKey(number)) {
        numbersMap.put(number, numbersMap.get(number) + 1);
      } else {
        numbersMap.put(number, 1);
      }
    }

    boolean containsSum(int sum) {
      for (int num : numbersMap.keySet()) {
        int value = sum - num;
        if (numbersMap.containsKey(value)) {
          if ((value == num) && numbersMap.get(num) < 2) {
            continue;
          }
          return true;
        }
      }
      return false;
    }
  }

  public static void main(String[] args) {
    TwoSum twoSum = new TwoSum();
    twoSum.add(1);
    twoSum.add(2);
    twoSum.add(4);
    twoSum.add(2);

    System.out.println(twoSum.containsSum(3));
    System.out.println(twoSum.containsSum(4));
    System.out.println(twoSum.containsSum(8));
  }
}
