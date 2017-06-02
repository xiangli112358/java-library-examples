package me.dev1001.examples.leetcode;

/**
 * Created by hongzong.li on 6/1/17.
 */
public class ValidPalindrome {

  public static boolean isValidPalindrome(String s) {
    if (s == null || s.length() == 0) {
      return false;
    }

    s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isValidPalindrome("Red  rum,  sir,  is  murder"));
    System.out.println(isValidPalindrome("abba"));
    System.out.println(isValidPalindrome("abab"));

    System.out.println(isValidPalindrome2("Red  rum,  sir,  is  murder"));
    System.out.println(isValidPalindrome2("abba"));
    System.out.println(isValidPalindrome2("abab"));
    System.out.println(isValidPalindrome2("a,"));

  }


  public static boolean isValidPalindrome2(String s) {
    if (s == null || s.length() == 0) {
      return false;
    }

    int i = 0;
    int j = s.length() - 1;
    while (true) {
      while (i < j && !isAlpha(s.charAt(i))) {
        i++;
      }
      if (i >= j) {
        break;
      }

      while (i < j && !isAlpha(s.charAt(j))) {
        j--;
      }
      if (j <= i) {
        break;
      }

      if (Character.toLowerCase(s.charAt(i)) !=  Character.toLowerCase(s.charAt(j))) {
        return false;
      }

      i++;
      j--;
    }
    return true;
  }

  private static boolean isAlpha(char ch) {
    return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
  }

}

