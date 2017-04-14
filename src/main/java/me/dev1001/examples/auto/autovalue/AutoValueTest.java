package me.dev1001.examples.auto.autovalue;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Comparator;
import me.dev1001.examples.auto.autovalue.support.AnnotationValue;
import me.dev1001.examples.auto.autovalue.support.ArrayValue;
import me.dev1001.examples.auto.autovalue.support.Named;
import me.dev1001.examples.auto.autovalue.support.Person;
import me.dev1001.examples.auto.autovalue.support.Person.Misc;
import me.dev1001.examples.auto.autovalue.support.PrefixedValue;
import me.dev1001.examples.auto.autovalue.support.Sex;
import org.junit.Test;

/**
 * Created by hongzong.li on 4/12/17.
 */
public class AutoValueTest {

  @Test
  public void testCreate() {
    Person person = Person.create("think", 20, Sex.MALE);
    assertEquals("think", person.name());
    assertEquals(20, person.age());
    assertSame(Sex.MALE, person.sex());
  }

  @Test
  public void testEqualsAndHashCode() {
    Person person = Person.create("think", 20, Sex.MALE);
    Person other = Person.create("think", 20, Sex.MALE);

    assertNotSame(person, other);
    assertEquals(person.hashCode(), other.hashCode());
    assertEquals(person, other);
  }

  @Test
  public void testToString() {
    Person person = Person.create("think", 20, Sex.MALE);
    String toString = "Person{name=think, age=20, sex=MALE}";
    assertEquals(toString, person.toString());
  }

  @Test
  public void testBuilder() {
    Person think = Person.builder()
        .name("think")
        .age(20)
        .sex(Sex.MALE)
        .build();
    assertEquals("think", think.name());
    assertEquals(20, think.age());
    assertSame(Sex.MALE, think.sex());
  }

  @Test
  public void testNullableValue() {
    Person think = Person.builder()
        .name("think")
        .age(20)
        .build();
    assertEquals("think", think.name());
    assertEquals(20, think.age());
    assertNull(think.sex());
  }

  @Test
  public void testNestedClass() {
    Misc misc = Misc.builder().address("beijing").build();
    assertEquals("beijing", misc.address());
  }

  @Test
  public void testPrefixedStyle() {
    PrefixedValue think = PrefixedValue.create("think", 20);
    assertEquals("think", think.getName());
    assertEquals(20, think.getAge());
  }

  @Test
  public void testMutator() {
    // person.setName("newName");
    // This will compile error, AutoValues are immutable and do not offer any mutator.
  }

  @Test
  public void testMemorized() {
    Person person = Person.create("think", 20, Sex.MALE);
    assertEquals("think: 20", person.desc());
    assertSame(person.desc(), person.desc()); // the returned object will be the same one.
  }

  @Test
  public void testIgnoredProperty() {
    Person person = Person.create("think", 20, Sex.MALE);
    assertTrue(person.isStudent());
  }

  @Test
  public void testComparator() {
    // There is no need to generate compareTo() method, cause Comparator(from java8) and
    // ComparisonChain(from guava) do a good job.
    Comparator.comparing(Person::name).thenComparing(Person::age);
  }

  @Test
  public void testPrimitiveArray() {
    ArrayValue ints = ArrayValue.create(new int[]{1, 2, 3});
    assertArrayEquals(new int[]{1, 2, 3}, ints.primitives());
  }

  @Test
  public void testAnnotation() {
    Named named = AnnotationValue.named("think");
    assertEquals("think", named.value());
  }

}
