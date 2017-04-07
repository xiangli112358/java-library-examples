package me.dev1001.examples.javatupples;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import org.hamcrest.CoreMatchers;
import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Triplet;
import org.javatuples.Unit;
import org.junit.Test;

/**
 * Created by hongzong.li on 4/5/17.
 */
public class JavaTuplesTest {

  public void desc() {
    // A tuple is a collection of several elements that may or may not be related to each other.
    // This library provides us ten different classes that would suffice most of our requirements
    // related to tuples:

    // * Unit<A>
    // * Pair<A,B>
    // * Triplet<A,B,C>
    // * Quartet<A,B,C,D>
    // * Quintet<A,B,C,D,E>
    // * Sextet<A,B,C,D,E,F>
    // * Septet<A,B,C,D,E,F,G>
    // * Octet<A,B,C,D,E,F,G,H>
    // * Ennead<A,B,C,D,E,F,G,H,I>
    // * Decade<A,B,C,D,E,F,G,H,I,J>

    // 1. These classes are type safe and immutable;
    // 2. Type parameters may or may not be the same type.
  }


  @Test
  public void testCreateInstance_explicitly() {
    // Note the types explicitly constructed can be different.
    // There are two special types of pair: KeyValue and LabelValue, which rename the value names.
    Pair<String, Integer> pair = new Pair<>("a", 1);
    assertEquals(2, pair.getSize());
    assertEquals("a", pair.getValue0());
    assertEquals(Integer.valueOf(1), pair.getValue1());
  }

  @Test
  public void testCreateInstance_withStaticFactory() {
    // Note the types constructed with factory method can be different.
    Pair<String, Integer> pair = Pair.with("a", 1);
    assertEquals("a", pair.getValue0());
    assertEquals(Integer.valueOf(1), pair.getValue1());
  }


  @Test
  public void testCreateInstance_fromArray() {
    // fromArray can only accept an array which has the exactly corresponding number of elements,
    // otherwise IllegalArgumentException will be thrown.
    Pair<String, String> fromArray = Pair.fromArray(new String[]{"a", "b"});
    assertEquals("a", fromArray.getValue0());
    assertEquals("b", fromArray.getValue1());

    // Less elements
    try {
      Pair.fromArray(new String[]{"a"});
      fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    // More elements
    try {
      Pair.fromArray(new String[]{"a", "b", "c"});
      fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

  }


  @Test
  public void testCreateInstance_fromCollection() {
    // fromCollection() can only accept a collection which has the exactly corresponding number of
    // elements, otherwise IllegalArgumentException will be thrown.
    Pair<String, String> fromCollection = Pair.fromCollection(Arrays.asList("a", "b"));
    assertEquals("a", fromCollection.getValue0());
    assertEquals("b", fromCollection.getValue1());

    // Less elements
    try {
      Pair.fromCollection(Arrays.asList("a"));
      fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    // More elements
    try {
      Pair.fromCollection(Arrays.asList("a", "b", "c"));
      fail();
    } catch (IllegalArgumentException e) {
      // expected
    }
  }


  @Test
  public void testCreateInstance_fromIterable() {
    // There are two overloads of fromIterable:
    // fromIterable(iterable), requires exactly number of elements.
    // fromIterable(iterable, index), this version does not have to exactly number of elements. if
    // the iterable has excess elements, the remained elements will be skipped, if the iterable
    // does not have enough elements, nulls will be filled. The index parameter indicates the number
    // of elements to skip.
    Pair<String, String> fromIterable = Pair.fromIterable(Arrays.asList("a", "b"));
    assertEquals("a", fromIterable.getValue0());
    assertEquals("b", fromIterable.getValue1());

    // Less elements
    try {
      Pair.fromIterable(Arrays.asList("a"));
      fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    // More elements
    try {
      Pair.fromIterable(Arrays.asList("a", "b", "c"));
      fail();
    } catch (IllegalArgumentException e) {
      // expected
    }

    // Allow more or less elements
    Pair<String, String> fromIterableWithIndex = Pair.fromIterable(Arrays.asList("a", "b", "c"), 1);
    assertEquals("b", fromIterableWithIndex.getValue0());
    assertEquals("c", fromIterableWithIndex.getValue1());

    // Allow less elements, fill with nulls if necessary
    Pair<String, String> fromIterableFillNulls = Pair.fromIterable(Arrays.asList("a", "b", "c"), 2);
    assertEquals("c", fromIterableFillNulls.getValue0());
    assertNull(fromIterableFillNulls.getValue1());
  }

  @Test
  public void testQueryValues() {
    Pair<String, Integer> pair = Pair.with("a", 1);

    // Type safe
    assertEquals("a", pair.getValue0());
    assertEquals(Integer.valueOf(1), pair.getValue1());

    // Not type safe, need cast
    Object value0 = pair.getValue(0);
    Object value1 = pair.getValue(1);
    assertThat(value0, allOf(instanceOf(String.class), CoreMatchers.<Object>equalTo("a")));
    assertThat(value1, allOf(instanceOf(Integer.class), CoreMatchers.<Object>equalTo(1)));
  }

  @Test
  public void testSetValues() {
    // Note tuple is immutable, invoke setAtX method will return a new tuple.
    Pair<String, String> pair = Pair.with("a", "b");

    assertEquals("a", pair.getValue0());
    pair = pair.setAt0("c");
    assertEquals("c", pair.getValue0());
  }


  @Test
  public void testAddValues() {
    Pair<String, String> pair = Pair.with("a", "b");

    // Add a single value
    Triplet<String, String, String> triplet = pair.add("c");
    assertEquals("a", triplet.getValue0());
    assertEquals("b", triplet.getValue1());
    assertEquals("c", triplet.getValue2());

    // Add an pair
    Quartet<String, String, String, String> doublePair = pair.add(Pair.with("c", "d"));
    assertTrue(doublePair.containsAll("a", "b"));
    assertTrue(doublePair.containsAll("c", "d"));

    // Remove a value
    Unit<String> name = pair.removeFrom1();
    assertEquals("a", name.getValue0());

    // Locate a value
    assertEquals(1, pair.indexOf("b"));
  }


  @Test
  public void testViews() {
    Triplet<String, String, String> triplet = Triplet.with("a", "b", "c");

    // To array
    Object[] array = triplet.toArray();
    assertEquals(Object[].class, array.getClass());
    assertArrayEquals(new String[]{"a", "b", "c"}, array);

    // To list
    assertEquals(Arrays.asList("a", "b", "c"), triplet.toList());
  }

}
