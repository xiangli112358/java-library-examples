package me.dev1001.examples.utils.common;

/**
 * Created by hongzong.li on 5/24/17.
 */
public class EnumConverterExample {

  public static void main(String[] args) {
    ReverseEnumMap<OrderStatus, Integer> statusMap = new ReverseEnumMap<>(OrderStatus.class);
    System.out.println(statusMap.get(0));
  }
}
