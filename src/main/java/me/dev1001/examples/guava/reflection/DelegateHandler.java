package me.dev1001.examples.guava.reflection;

import com.google.common.reflect.AbstractInvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by hongzong.li on 5/15/17.
 */
public final class DelegateHandler extends AbstractInvocationHandler {
  private Car car;

  public DelegateHandler(Car car) {
    this.car = car;
  }

  @Override
  protected Object handleInvocation(Object proxy, Method method, Object[] args) throws Throwable {
    return method.invoke(car, args);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj instanceof DelegateHandler) {
      DelegateHandler that = ((DelegateHandler) obj);
      return car.equals(that.car);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return car.hashCode();
  }

  @Override
  public String toString() {
    return car.toString();
  }
}
