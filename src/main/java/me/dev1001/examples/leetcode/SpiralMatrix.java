package me.dev1001.examples.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongzong.li on 6/1/17.
 */
public class SpiralMatrix {

  public static List<Integer> spiralTraversal(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0) {
      return result;
    }

    int m = matrix.length;
    int n = matrix[0].length;

    int x = 0;
    int y = 0;
    while (m > 0 && n > 0) {
      if (m == 1) {
        for (int i = 0; i < n; i++) {
          result.add(matrix[x][y++]);
        }
        break;
      }
      if (n == 1) {
        for (int i = 0; i < m; i++) {
          result.add(matrix[x++][y]);
        }
        break;
      }

      for (int i = 0; i < n - 1; i++) {
        result.add(matrix[x][y++]);
      }
      for (int i = 0; i < m - 1; i++) {
        result.add(matrix[x++][y]);
      }
      for (int i = 0; i < n - 1; i++) {
        result.add(matrix[x][y--]);
      }
      for (int i = 0; i < m - 1; i++) {
        result.add(matrix[x--][y]);
      }

      m -= 2;
      n -= 2;
      x++;
      y++;
    }
    return result;
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][]{
        {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
    };
    System.out.println(spiralTraversal(matrix));
  }
}
