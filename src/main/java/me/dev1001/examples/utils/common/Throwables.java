package me.dev1001.examples.utils.common;

/**
 * @author think on 12/11/2018
 */
public class Throwables {

  private Throwables() {
  }

  public static void throwUnchecked(final Throwable ex) {
    Throwables.rethrow(ex);
  }

  @SuppressWarnings("unchecked")
  private static <T extends Throwable> void rethrow(final Throwable t) throws T {
    throw (T) t;
  }

  public static void main(String[] args) {
    Exception e = new Exception("ex");
    throwUnchecked(e);
  }
}
