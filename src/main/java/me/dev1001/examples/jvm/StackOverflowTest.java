package me.dev1001.examples.jvm;

/**
 * @author hongzong.li
 */
public class StackOverflowTest {
    private static int count = 0;

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        System.out.println(++count);
        test();
    }
}
