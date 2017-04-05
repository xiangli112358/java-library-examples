package me.dev1001.examples.javatupples;

import javafx.util.Pair;
import org.javatuples.Triplet;

import java.util.Arrays;

/**
 * Created by hongzong.li on 4/5/17.
 */
public class JavaTuplesExample {
    public static void main(String[] args) {
        // A tuple is a collection of several elements that may or may not be related to each other.
        // This library provides us ten different classes that would suffice most of our requirements related to tuples:

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

        // ==========================================Create======================================================

        // Explicitly constructed
        // Note the types explicitly constructed can be different.
        Pair<String, Integer> pair = new Pair<>("a", 1);
        System.out.println(pair); // a=1

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
        // fromCollection() can only accept a collection which has the exactly corresponding number of elements,
        // otherwise IllegalArgumentException will be thrown.
        Triplet<String, String, String> fromCollection = Triplet.fromCollection(Arrays.asList("a", "b", "c"));
        System.out.println(fromCollection); // [a, b, c]

        // From iterable
        // There are two overloads of fromIterable:
        // fromIterable(iterable), requires exactly number of elements.
        // fromIterable(iterable, index), this version does not have to exactly number of elements. if the iterable has
        // excess elements, the remained elements will be skipped; if does not have enough elements, nulls will be
        // filled. The index parameter indicates the number of elements to skip.
        Triplet< String, String, String> fromIterable = Triplet.fromIterable(Arrays.asList("a", "b", "c"));
        System.out.println(fromIterable); // [a, b, c]

        Triplet< String, String, String> fromIterableWithIndex = Triplet.fromIterable(Arrays.asList("a", "b", "c", "d"), 0);
        System.out.println(fromIterableWithIndex); // [a, b, c]

        Triplet<String, String, String> fromIterableFillNulls = Triplet.fromIterable(Arrays.asList("a", "b", "c", "d"), 3);
        System.out.println(fromIterableFillNulls); // [d, null, null]


        // ========================================Create End====================================================
    }
}
