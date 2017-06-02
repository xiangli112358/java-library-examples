package me.dev1001.examples.leetcode;

/**
 * Created by hongzong.li on 6/1/17.
 */
public class AddBinary {
  public static String addBinary(String a, String b) {
    if (a == null || a.length() == 0) {
      return b;
    }
    if (b == null || b.length() == 0) {
      return a;
    }

    int pa = a.length() - 1;
    int pb = b.length() - 1;
    int carry = 0;
    StringBuilder result = new StringBuilder(a.length() + b.length() + 1);
    while (pa >= 0 || pb >= 0) {
      int va = 0;
      int vb = 0;
      if (pa >= 0) {
        va = a.charAt(pa) == '0' ? 0 : 1;
        pa--;
      }
      if (pb >= 0) {
        vb = b.charAt(pb) == '0' ? 0 : 1;
        pb--;
      }
      int sum = va + vb + carry;
      if (sum >= 2) {
        result.append(sum - 2);
        carry = 1;
      } else {
        result.append(sum);
      }
    }
    if (carry > 0) {
      result.append(carry);
    }
    return result.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println(addBinary("1000", "1111"));
  }
}
