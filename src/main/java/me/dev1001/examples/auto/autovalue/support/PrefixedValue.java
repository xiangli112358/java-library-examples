package me.dev1001.examples.auto.autovalue.support;

import com.google.auto.value.AutoValue;

/**
 * Created by hongzong.li on 4/13/17.
 */
@AutoValue
public abstract class PrefixedValue {

  public abstract String getName();

  public abstract int getAge();

  public static PrefixedValue create(String newName, int newAge) {
    return new AutoValue_PrefixedValue(newName, newAge);
  }

}
