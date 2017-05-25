package me.dev1001.examples.utils.common;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Enumeration;
import java.util.Iterator;

public class IterableEnumeration<T> implements Iterable<T> {

  private final Enumeration<T> en;

  public IterableEnumeration(Enumeration<T> en) {
    this.en = en;
  }

  // return an adaptor for the Enumeration
  public Iterator<T> iterator() {
   return new UnmodifiableIterator<T>() {
     @Override
     public boolean hasNext() {
       return en.hasMoreElements();
     }

     @Override
     public T next() {
       return en.nextElement();
     }
   };
  }

  public static <T> Iterable<T> make(Enumeration<T> en) {
    return new IterableEnumeration<>(en);
  }
}