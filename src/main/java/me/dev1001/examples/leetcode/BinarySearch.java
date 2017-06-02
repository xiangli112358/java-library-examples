package me.dev1001.examples.leetcode;

/**
 * Created by hongzong.li on 6/1/17.
 */
public class BinarySearch {

  public static int binarySearch(int[] array, int target) {
   return binarySearch(array, 0, array.length - 1, target);
  }

  public static int binarySearch(int[] array, int low, int high, int target) {

    while (low <= high) {
      // int mid = (start + end) >>> 2;
      int mid = (high - low) / 2 + low;
      if (array[mid] == target) {
        return mid;
      } else if (array[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }

}
