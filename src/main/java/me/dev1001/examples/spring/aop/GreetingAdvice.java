package me.dev1001.examples.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author hongzong.li
 */
public class GreetingAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Hi, ....");
        Object result = methodInvocation.proceed();
        System.out.println("Done hi.");
        return result;
    }
}
