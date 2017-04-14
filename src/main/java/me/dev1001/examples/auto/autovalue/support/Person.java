package me.dev1001.examples.auto.autovalue.support;

import com.google.auto.value.AutoValue;
import com.google.auto.value.extension.memoized.Memoized;
import javax.annotation.Nullable;


/**
 * Created by hongzong.li on 4/12/17.
 */
@AutoValue
public abstract class Person {

  public abstract String name();

  public abstract int age();

  @Nullable
  public abstract Sex sex();

  private boolean isStudent;


  public boolean isStudent() {
    return isStudent;
  }

  @Memoized
  public String desc() {
    return name() + ": " + age();
  }

  @AutoValue
  public abstract static class Misc {
    public abstract String address();

    public static Builder builder() {
      return new AutoValue_Person_Misc.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {

      public abstract Builder address(String address);

      public abstract Misc build();
    }
  }

  public static Person create(String name, int age, Sex sex) {
    Person person = builder()
        .name(name)
        .age(age)
        .sex(sex)
        .build();
    person.isStudent = age <= 20;
    return person;
  }


  public static Builder builder() {
    return new AutoValue_Person.Builder();
  }


  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder name(String name);

    public abstract Builder age(int age);

    public abstract Builder sex(Sex sex);

    public abstract Person build();
  }


}
