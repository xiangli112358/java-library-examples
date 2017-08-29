package me.dev1001.examples.spring.aop;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author hongzong.li
 */
public class AopExample {


    public static void main(String[] args) {
        TestService testService = new TestServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(testService);
        proxyFactory.addAdvice(new GreetingAdvice());

        TestService proxiedService = (TestService) proxyFactory.getProxy();

        proxiedService.test();

    }


}
