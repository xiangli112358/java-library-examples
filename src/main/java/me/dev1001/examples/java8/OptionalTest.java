package me.dev1001.examples.java8;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.common.base.Predicates;
import com.google.common.base.Suppliers;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;
import org.junit.Test;

/**
 * Created by hongzong.li on 4/19/17.
 */
public class OptionalTest {

  private static final Object VALUE = new Object();

  @Test
  public void testIsPresent() {
    assertFalse(Optional.empty().isPresent());

    Optional<Object> nullable = Optional.ofNullable(null);
    assertFalse(nullable.isPresent());

    nullable = Optional.ofNullable(VALUE);
    assertTrue(nullable.isPresent());
  }

  @Test
  public void testGet() {
    Optional<Object> present = Optional.of(VALUE);
    assertSame(VALUE, present.get());

    Optional<String> empty = Optional.empty();
    assertFalse(empty.isPresent());
    try {
      empty.get();
      fail();
    } catch (NoSuchElementException e) {
      // expected
    }
  }


  @Test
  public void testIfPresent() {
    Optional<Object> nullable = Optional.ofNullable(null);

    ValueCapture<Object> capture = new ValueCapture<>();
    nullable.ifPresent(capture);
    assertNull(capture.get());

    nullable = Optional.of(VALUE);
    nullable.ifPresent(capture);
    assertSame(VALUE, capture.get());
  }

  @Test
  public void testMap() {
    // empty map
    Optional<Object> empty = Optional.empty().map(v -> v);
    assertFalse(empty.isPresent());

    Optional<Object> present = Optional.of(VALUE).map(v -> v);
    assertTrue(present.isPresent());
    assertSame(VALUE, present.get());
  }

  @Test
  public void testFlatMap() {
    // empty flat map
    Optional<Object> empty = Optional.empty().flatMap(Optional::of);
    assertFalse(empty.isPresent());

    Optional<Object> present = Optional.of(VALUE).flatMap(Optional::of);
    assertSame(VALUE, present.get());
  }


  @Test
  public void testFilter() {
    Optional<Object> empty = Optional.empty().filter(Predicates.alwaysTrue());
    assertFalse(empty.isPresent());

    empty = Optional.of(VALUE).filter(Predicates.alwaysFalse());
    assertFalse(empty.isPresent());

    Optional<Object> present = Optional.of(VALUE).filter(Predicates.alwaysTrue());
    assertSame(VALUE, present.get());
  }

  @Test
  public void testOrElse() {
    Object defaultValue = new Object();
    Object value = Optional.empty().orElse(defaultValue);
    assertSame(value, defaultValue);

    value = Optional.of(VALUE).orElse(defaultValue);
    assertSame(VALUE, value);
  }

  @Test
  public void testOrElseGet() {
    Object defaultValue = new Object();
    Object value = Optional.empty().orElseGet(Suppliers.ofInstance(defaultValue));
    assertSame(defaultValue, value);

    value = Optional.of(VALUE).orElseGet(Suppliers.ofInstance(defaultValue));
    assertSame(VALUE, value);
  }


  @Test
  public void testOrElseThrow() {
    try {
     Optional.empty().orElseThrow(Exception::new);
     fail();
    } catch (Exception e) {
      // expected
    }

    try {
      Object value = Optional.of(VALUE).orElseThrow(Exception::new);
      assertSame(VALUE, value);
    } catch (Exception e) {
      fail();
    }

  }

  private static final class ValueCapture<T> implements Consumer<T> {

    private T value;

    @Override
    public void accept(T t) {
      this.value = t;
    }


    T get() {
      return value;
    }
  }


}
