package me.dev1001.examples.javatupples;

import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Triplet;
import org.javatuples.Unit;

import java.util.Arrays;

/**
 * Created by hongzong.li on 4/5/17.
 */
public class JavaTuplesExample {

  public static void main(String[] args) {
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

    testCreate();
    testQueryValues();
    testSetValues();
    testAddValues();
    testConvert();
  }


  private static void testCreate() {
    // Explicitly constructed
    // Note the types explicitly constructed can be different.
    // There are two special types of pair: KeyValue and LabelValue, which rename the value names.
    Pair<String, Integer> pair = new Pair<>("a", 1);
    System.out.println(pair); // [a, 1]

    Triplet<String, Integer, Integer> explicitly = new Triplet<>("a", 1, 2);
    System.out.println(explicitly); // [a, 1, 2]

    // With static factory method
    // Note the types constructed with factory method can be different.
    Triplet<String, String, String> withFactory = Triplet.with("a", "1", "2");
    System.out.println(withFactory); // [a, 1, 2]

    // From array
    // fromArray can only accept an array which has the exactly corresponding number of elements,
    // otherwise IllegalArgumentException will be thrown.
    Triplet<String, String, String> fromArray = Triplet.fromArray(new String[]{"a", "b", "c"});
    System.out.println(fromArray); // [a, b, c]

    // From collection
    // fromCollection() can only accept a collection which has the exactly corresponding number of
    // elements, otherwise IllegalArgumentException will be thrown.
    Triplet<String, String, String> fromCollection = Triplet
        .fromCollection(Arrays.asList("a", "b", "c"));
    System.out.println(fromCollection); // [a, b, c]

    // From iterable
    // There are two overloads of fromIterable:
    // fromIterable(iterable), requires exactly number of elements.
    // fromIterable(iterable, index), this version does not have to exactly number of elements. if
    // the iterable has excess elements, the remained elements will be skipped, if the iterable
    // does not have enough elements, nulls will be filled. The index parameter indicates the number
    // of elements to skip.
    Triplet<String, String, String> fromIterable = Triplet
        .fromIterable(Arrays.asList("a", "b", "c"));
    System.out.println(fromIterable); // [a, b, c]

    Triplet<String, String, String> fromIterableWithIndex = Triplet
        .fromIterable(Arrays.asList("a", "b", "c", "d"), 0);
    System.out.println(fromIterableWithIndex); // [a, b, c]

    Triplet<String, String, String> fromIterableFillNulls = Triplet
        .fromIterable(Arrays.asList("a", "b", "c", "d"), 3);
    System.out.println(fromIterableFillNulls); // [d, null, null]

  }

  private static void testQueryValues() {
    Triplet<String, Integer, Integer> triplet = Triplet.with("a", 1, 2);

    String value0;
    Integer value1;
    Integer value2;
    // type safe
    value0 = triplet.getValue0();
    value1 = triplet.getValue1();
    value2 = triplet.getValue2();
    System.out.printf("value0=%s, value1=%d, value2=%d\n", value0, value1,
        value2); // value0=a, value1=1, value2=2

    // not type safe, need cast
    value0 = ((String) triplet.getValue(0));
    value1 = ((Integer) triplet.getValue(1));
    value2 = ((Integer) triplet.getValue(2));
    System.out.printf("value0=%s, value1=%d, value2=%d\n", value0, value1,
        value2); // value0=a, value1=1, value2=2
  }

  private static void testSetValues() {
    Pair<String, Integer> pair = Pair.with("think", 28);
    System.out.println(pair); // [think, 28]
    // Note tuple is immutable, invoke setAtX method will return a new tuple.
    pair = pair.setAt1(27);
    System.out.println(pair); // [think, 27]
  }


  private static void testAddValues() {
    Pair<String, Integer> pair = Pair.with("think", 28);
    System.out.println(pair); // [think, 28]

    // Add a single value
    Triplet<String, Integer, String> triplet = pair.add("Beijing");
    System.out.println(triplet); // [think, 28, Beijing]
    System.out.println(triplet.contains("Beijing")); // true

    // Add an pair
    Quartet<String, Integer, String, Integer> doublePair = pair.add(pair);
    System.out.println(doublePair.containsAll(pair.toArray())); // true
    System.out.println(doublePair.containsAll(pair)); // false

    // Remove a value
    Unit<String> name = pair.removeFrom1();
    System.out.println(name); // [think]

    // Locate a value
    Triplet<String, String, Integer> newTriplet = pair.addAt1("li");
    System.out.println(newTriplet.contains("li")); // true
    System.out.println(newTriplet.indexOf("li")); // 1
  }


  private static void testConvert() {
    Triplet<String, String, Integer> think = Triplet.with("think", "li", 27);

    // To array
    Object[] thinkArray = think.toArray();
    System.out.println(thinkArray.getClass()); // class [Ljava.lang.Object;
    System.out.println(Arrays.toString(thinkArray)); //  [think, li, 27]

    // To list
    System.out.println(think.toList()); // [think, li, 27]
  }

}
