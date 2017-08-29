package me.dev1001.examples.spring.aop;

/**
 * @author hongzong.li
 */
public class TestServiceImpl implements TestService {
    @Override
    public void test() {
        System.out.println("this is a test service.");
    }
}
