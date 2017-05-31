package me.dev1001.examples.leetcode;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by hongzong.li on 5/31/17.
 */
public class TwoSumII {

  // if the numbers are ordered
  public static int[] findTwoSum(int[] ordered, int sum) {
    Objects.requireNonNull(ordered);
    int i = 0;
    int j = ordered.length - 1;

    while (i < j) {
      int target = ordered[i] + ordered[j];
      if (target == sum) {
        return new int[]{i + 1, j + 1};
      } else if (target > sum) {
        j--;
      } else {
        i++;
      }
    }
    return new int[]{};
  }

  public static void main(String[] args) {
    int[] numbers = new int[]{1, 2, 7, 10};
    System.out.println(Arrays.toString(findTwoSum(numbers, 9)));
  }
}
