package me.dev1001.examples.guava.reflection;

import com.google.common.reflect.Reflection;

/**
 * Created by hongzong.li on 5/15/17.
 */
public class ProxyExample {

  public static void main(String[] args) {
    DelegateHandler redHandler = new DelegateHandler(new CarImpl("red"));
    DelegateHandler greenHandler = new DelegateHandler(new CarImpl("green"));

    System.out.println(redHandler);
    System.out.println(greenHandler);

    Car redCar1 = Reflection.newProxy(Car.class, redHandler);
    Car redCar2 = Reflection.newProxy(Car.class, redHandler);
    System.out.println(redCar1 == redCar2);
    System.out.println(redCar1.equals(redCar2));

    Car greenCar = Reflection.newProxy(Car.class, greenHandler);
    System.out.println(redCar1.equals(greenCar));
  }

}
