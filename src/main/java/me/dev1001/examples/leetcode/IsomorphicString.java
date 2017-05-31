package me.dev1001.examples.leetcode;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by hongzong.li on 5/26/17.
 */
public class IsomorphicString {

  // Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic if
  // the characters in s can be replaced to get t. For example,"egg" and "add" are isomorphic,
  // "foo" and "bar" are not
  public static boolean isIsomorphic(String s, String t) {
    Objects.requireNonNull(s);
    Objects.requireNonNull(t);

    if (s.length() != t.length()) {
      return false;
    }

    if (s.length() == 0) {
      return true;
    }

    Map<Character, Character> mapping = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      Character ch1 = s.charAt(i);
      Character ch2 = t.charAt(i);

      Character key = getKey(mapping, ch2);
      if (!mapping.containsKey(ch1)) {
        if (key != null && !key.equals(ch1)) {
          return false;
        } else {
          mapping.put(ch1, ch2);
        }
      } else if (!mapping.get(ch1).equals(ch2)) {
        return false;
      }
    }
    return true;
  }

  private static Character getKey(Map<Character, Character> mapping, Character value) {
    for (Map.Entry<Character, Character> entry : mapping.entrySet()) {
      if (entry.getValue().equals(value)) {
        return entry.getKey();
      }
    }
    return null;
  }


  public static boolean isIsomorphic2(String s, String t) {
    BiMap<Character, Character> mapping = HashBiMap.create();
    for (int i = 0; i < s.length(); i++) {
      if (!mapping.containsKey(s.charAt(i))) {
        try {
          mapping.put(s.charAt(i), t.charAt(i));
        } catch (Exception e) {
          return false;
        }
      } else if (!mapping.get(s.charAt(i)).equals(t.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(isIsomorphic2("add", "egg"));
    System.out.println(isIsomorphic2("foo", "bar"));
    System.out.println(isIsomorphic2("ab", "aa"));
    System.out.println(isIsomorphic2("aa", "ba"));

  }
}
