package me.dev1001.examples.leetcode;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by hongzong.li on 5/31/17.
 */
public class ClosestThreeSum {

  public static int closestThreeSum(int[] numbers, int target) {
    Objects.requireNonNull(numbers);
    checkArgument(numbers.length >= 3);

    Arrays.sort(numbers);

    int result = 0;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < numbers.length - 2; i++) {
      int j = i + 1;
      int k = numbers.length - 1;
      while (j < k) {
        int sum = numbers[i] + numbers[j] + numbers[k];
        int diff = Math.abs(sum - target);
        if (diff == 0) {
          return target;
        } else if (diff < min) {
          result = sum;
        }
        if (sum < target) {
          j++;
        } else {
          k--;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] numbers = new int[] { 1, 3, 0, -1, 2, 5};
    System.out.println(closestThreeSum(numbers, 19));
  }
}
