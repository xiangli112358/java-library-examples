package me.dev1001.examples.leetcode;

/**
 * Created by hongzong.li on 6/1/17.
 */
public class RemoveElement {

  public static int remove(int[] array, int elem) {
    int i = 0;
    int j = 0;
    while (j < array.length) {
      if (array[j] != elem) {
        array[i++] = array[j];
      }
      j++;
    }
    return i;
  }

  public static void main(String[] args) {
    int[] numbers = new int[]{1, 1, 2, 3, 1, 5};
    System.out.println(remove(numbers, 1));
  }

}
