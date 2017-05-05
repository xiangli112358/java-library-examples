package me.dev1001.examples.spring;

import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.TimeUnit;
import org.springframework.util.ConcurrentReferenceHashMap;
import org.springframework.util.ConcurrentReferenceHashMap.ReferenceType;

/**
 * Created by hongzong.li on 5/5/17.
 */
public class ConcurrentReferenceMapTest {

  public static void main(String[] args) {
    ConcurrentReferenceHashMap<Person, String> map =
        new ConcurrentReferenceHashMap<>(16, ReferenceType.WEAK);

    Person p = new Person("think", 27);
    map.put(p, "think");

    helpGC();
    System.out.println(map.get(p)); // weired result, here we get null even if the strong reference exists.

    System.out.println(map.size());
  }

  private static void helpGC() {
    for (int i = 0; i < 10; i++) {
      Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
      System.gc();
    }
  }

  private static class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Person person = (Person) o;

      if (age != person.age) {
        return false;
      }
      return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
      int result = name != null ? name.hashCode() : 0;
      result = 31 * result + age;
      return result;
    }

    @Override
    public String toString() {
      return "Person{" +
          "name='" + name + '\'' +
          ", age=" + age +
          '}';
    }
  }

}
