package me.dev1001.examples.java8;

import java.util.Arrays;
import java.util.List;

/**
 * @author think on 12/11/2018
 */
public class SubStreamCastExample {

  public static void main(String[] args) {
    List<Number> numbers  = Arrays.asList(1, 2);
    numbers.stream().map(Integer.class::cast).forEach(System.out::println);
  }

}
