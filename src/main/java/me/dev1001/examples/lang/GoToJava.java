package me.dev1001.examples.lang;

import java.util.concurrent.ThreadLocalRandom;

public class GoToJava {

  public void foo() {
    here:
    {
      if (ThreadLocalRandom.current().nextBoolean()) {
        System.out.println("First random true");
        break here;
      }
      if (ThreadLocalRandom.current().nextBoolean()) {
        System.out.println("Second random true");
        break here;
      }
      System.out.println("Both randoms false");
    }
    System.out.println("Done");
  }

  public static void main(String[] args) {
    new GoToJava().foo();
  }
}