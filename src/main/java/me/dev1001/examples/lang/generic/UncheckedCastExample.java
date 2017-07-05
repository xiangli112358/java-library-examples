package me.dev1001.examples.lang.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author hongzong.li
 */
public class UncheckedCastExample {
  public static <T> T[] cast(T[] array) {



    return (T[]) Arrays.copyOf(array, array.length, array.getClass());
  }

  public static void main(String[] args) {
//    B[] b = new B[10];
//    A[] cast = UncheckedCastExample.<A>cast(b);
//    cast[0] = new A();

    String[] strings = (String[]) new Object[10];
    strings[0] = "hello";

    List<? extends Number> integers = new ArrayList<Integer>();
    Iterator<? extends Number> iterator = integers.iterator();
    Number next = iterator.next();
  }

  private static class A {}

  private static class B extends A {}
}
