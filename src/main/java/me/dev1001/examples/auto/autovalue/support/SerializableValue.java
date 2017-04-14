package me.dev1001.examples.auto.autovalue.support;

import com.google.auto.value.AutoValue;
import java.io.Serializable;

/**
 * Created by hongzong.li on 4/14/17.
 */
@AutoValue
public abstract class SerializableValue implements Serializable {

  private static final long serialVersionUID = -561156877571355793L;

  public abstract String name();

  public static SerializableValue create(String name) {
    return new AutoValue_SerializableValue(name);
  }


}
