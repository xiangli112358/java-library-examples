package me.dev1001.examples.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by hongzong.li on 5/31/17.
 */
public class ThreeSum {

  private static class Triplet {

    int i;
    int j;
    int k;

    public Triplet(int i, int j, int k) {
      this.i = i;
      this.j = j;
      this.k = k;
    }

    @Override
    public String toString() {
      return "[" + i + ", " + j + ", " + k + "]";
    }
  }

  public static List<Triplet> findThreeSum(int[] numbers, int sum) {
    Objects.requireNonNull(numbers);

    List<Triplet> result = new ArrayList<>();
    if (numbers.length < 3) {
      return result;
    }

    Arrays.sort(numbers);

    for (int i = 0; i < numbers.length - 2; i++) {
      List<int[]> twoSums = findTwoSum(numbers, i + 1, numbers.length - 1, sum - numbers[i]);
      for (int[] twoSum : twoSums) {
        result.add(new Triplet(numbers[i], twoSum[0], twoSum[1]));
      }
    }
    return result;
  }

  private static List<int[]> findTwoSum(int[] numbers, int begin, int end, int twoSum) {
    List<int[]> result = new ArrayList<>();
    while (begin < end) {
      int target = numbers[begin] + numbers[end];
      if (target == twoSum) {
        result.add(new int[] {numbers[begin], numbers[end]});
        begin++;
        end--;
      } else if (target < twoSum) {
        begin++;
      } else {
        end--;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] numbers = new int[] {1, 3, 0, -1, 2, 5};
    System.out.println(findThreeSum(numbers, 5));
  }

}
