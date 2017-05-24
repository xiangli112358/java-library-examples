package me.dev1001.examples.lang.reflection;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DelegationHandler implements InvocationHandler {

  private final Object wrapped;

  public DelegationHandler(Object wrapped) {
    this.wrapped = wrapped;
  }

  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    return method.invoke(wrapped, args);
  }
}