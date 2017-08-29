package me.dev1001.examples.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author hongzong.li
 */
@RunWith(Parameterized.class)
public class ParameterizedExample {

    private final int a1;
    private final int a2;
    private final int sum;

    public ParameterizedExample(int a1, int a2, int sum) {
        this.a1 = a1;
        this.a2 = a2;
        this.sum = sum;
    }

    @Parameterized.Parameters(name = "{index}: {0} + {1} = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
            new Object[] {1, 2, 3},
            new Object[] {4, 5, 9},
            new Object[] {1, 0, 1}
        );
    }


    @Test
    public void testAddition() {
        Assert.isTrue(a1 + a2 == sum);
    }




}
