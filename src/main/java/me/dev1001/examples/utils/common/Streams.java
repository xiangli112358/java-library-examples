package me.dev1001.examples.utils.common;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author think on 12/11/2018
 */
public class Streams {

  public static <T> Stream<T> iterate(Iterator<T> sourceIterator) {
    Iterable<T> iterable = () -> sourceIterator;
    return StreamSupport.stream(iterable.spliterator(), false);
  }


  public static <T> Stream<T> iterate(Iterable<T> iterable) {
    return StreamSupport.stream(iterable.spliterator(), false);
  }

}
