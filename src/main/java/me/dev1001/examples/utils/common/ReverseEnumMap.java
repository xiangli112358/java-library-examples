package me.dev1001.examples.utils.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hongzong.li on 5/24/17.
 */
public class ReverseEnumMap<E extends Enum<E> & EnumConverter<E, V>, V> {
  private final Map<V, Enum<E>> reverse;

  public ReverseEnumMap(Class<E> clazz) {
    E[] enumConstants = clazz.getEnumConstants();
    reverse = new HashMap<>();
    for (E e : enumConstants) {
      reverse.put(e.convert(), e);
    }
  }

  public Enum<E> get(V value) {
    return reverse.get(value);
  }
}
