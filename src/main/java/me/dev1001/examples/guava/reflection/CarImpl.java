package me.dev1001.examples.guava.reflection;

/**
 * Created by hongzong.li on 5/15/17.
 */
public final class CarImpl implements Car {

  private String color;

  public CarImpl(String color) {
    this.color = color;
  }

  @Override
  public String getColor() {
    return color;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    CarImpl car = (CarImpl) o;

    return color != null ? color.equals(car.color) : car.color == null;
  }

  @Override
  public int hashCode() {
    return color != null ? color.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "CarImpl(" + color + ")";
  }
}
