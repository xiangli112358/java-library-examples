package me.dev1001.examples.junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/**
 * @author hongzong.li
 */
public class TestNameRuleExample {

    @Rule
    public TestName name = new TestName();

    @Test
    public void testTestNameAware() {
        System.out.println(name.getMethodName());
    }
}
