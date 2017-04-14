package me.dev1001.examples.auto.autovalue.support;

import com.google.auto.value.AutoValue;

/**
 * Created by hongzong.li on 4/14/17.
 */
@AutoValue
public abstract class ArrayValue {

  public abstract int[] primitives();

  public static ArrayValue create(int[] primitives) {
    return builder()
        .primitives(primitives)
        .build();
  }

  public static Builder builder() {
    return new AutoValue_ArrayValue.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder primitives(int[] primitives);

    public abstract ArrayValue build();
  }

  // not allowed
//  abstract String[] objects();


}
