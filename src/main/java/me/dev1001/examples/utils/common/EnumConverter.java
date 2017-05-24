package me.dev1001.examples.utils.common;

/**
 * Created by hongzong.li on 5/24/17.
 */
public interface EnumConverter<E extends Enum<E>, V> {
  V convert();
}
