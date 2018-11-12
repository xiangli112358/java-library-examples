package me.dev1001.examples.junit;

import me.dev1001.examples.junit.DuplicateTestExample.A;
import me.dev1001.examples.junit.DuplicateTestExample.B;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author hongzong.li
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({A.class, B.class})
public class DuplicateTestExample {

    public static class A {
        @Test
        public void a() {
            System.out.println(getClass().getSimpleName() + ".a()");
        }

    }

    public static class B extends A {

        @Test
        public void b() {
            System.out.println(getClass().getSimpleName() + ".b()");
        }
    }

    @RunWith(Suite.class)
    @Suite.SuiteClasses({A.class, B.class})
    public static class TestSuite {

    }
}
