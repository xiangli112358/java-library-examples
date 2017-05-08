package me.dev1001.examples.java8;

import static java.util.stream.Collectors.joining;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * Created by hongzong.li on 5/8/17.
 */
public class ParameterNameReflectionExample {

  public static void main(String[] args) {
    for (Method method : Example.class.getDeclaredMethods()) {
      String parameters = Arrays.stream(method.getParameters())
          .map(Parameter::getName)
          .collect(joining(", "));
      System.out.println(method.getName() + "(" + parameters + ")");
    }
  }

  private static class Example {
    public static void testMethod(String param1, String param2) {

    }
  }
}
