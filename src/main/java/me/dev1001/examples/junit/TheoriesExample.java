package me.dev1001.examples.junit;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/**
 * @author hongzong.li
 */
@RunWith(Theories.class)
public class TheoriesExample {

    @DataPoint
    public static String first = "first";

    @DataPoint
    public static String second = "second";


    @Theory
    public void testTheory(String first, String second) {
        System.out.println("first: " + first + ", second: " + second);
    }
}
