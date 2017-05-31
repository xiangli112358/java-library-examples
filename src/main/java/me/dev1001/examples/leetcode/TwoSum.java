package me.dev1001.examples.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by hongzong.li on 5/31/17.
 */
public class TwoSum {

  public static int[] findTwoSum(int[] numbers, int sum) {
    Objects.requireNonNull(numbers);

    Map<Integer, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < numbers.length; i++) {
      if (indexMap.containsKey(sum - numbers[i])) {
        return new int[]{indexMap.get(sum - numbers[i]), i + 1};
      } else {
        indexMap.put(numbers[i], i + 1);
      }
    }
    return new int[]{};
  }


  public static void main(String[] args) {
    int[] numbers = new int[]{2, 7, 11, 15};
    System.out.println(Arrays.toString(findTwoSum(numbers, 17)));
  }
}
