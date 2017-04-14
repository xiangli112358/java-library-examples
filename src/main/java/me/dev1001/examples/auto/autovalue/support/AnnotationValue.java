package me.dev1001.examples.auto.autovalue.support;

import com.google.auto.value.AutoAnnotation;

/**
 * Created by hongzong.li on 4/14/17.
 */
public class AnnotationValue {
  @AutoAnnotation
  public static Named named(String value) {
    return new AutoAnnotation_AnnotationValue_named(value);
  }
}
