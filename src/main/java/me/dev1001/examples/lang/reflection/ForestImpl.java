package me.dev1001.examples.lang.reflection;

public class ForestImpl implements Forest {

  private final String color;

  public ForestImpl(String color) {
    this.color = color;
  }

  public String getColor() {
    return color;
  }

  @Override
  public boolean equals(Object o) {
    return equalsCallBack(o, false);
  }

  @Override
  public boolean equalsCallBack(Object o, boolean calledOnWrappedObject) {
    if (!(o instanceof Forest)) {
      return false;
    }
    Forest forest = (Forest) o;
    if (calledOnWrappedObject) {
      if (!(forest instanceof ForestImpl)) {
        return false;
      }
      return color.equals(((ForestImpl) o).color);
    } else {
      return forest.equalsCallBack(this, true);
    }
  }
}