package me.dev1001.examples.lang.reflection;

import java.lang.reflect.Proxy;

public class ProxyEquality {

  public static void main(String[] args) {

    Forest impl = new ForestImpl("Black");
    DelegationHandler dh = new DelegationHandler(impl);

    Forest i0 = make(dh);
    Forest i1 = make(dh);
    System.out.println(i0 == i1); // should be false
    System.out.println(i0.equals(i1)); // should be true
    System.out.println(impl.equals(new ForestImpl("Black"))); // should be true

  }

  private static Forest make(DelegationHandler dh) {
    return (Forest) Proxy.newProxyInstance(
        Forest.class.getClassLoader(),
        new Class[]{Forest.class},
        dh);
  }
}