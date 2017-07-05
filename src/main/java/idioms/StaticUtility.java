package idioms;


/**
 * Note, although abstract class can not be constructed, but it can be extended.
 * So do not use abstract class to implement static utility idiom.
 *
 * Using private constructor is the right way to do this, note that make the class
 * final to prevent being extended.
 */
public final class StaticUtility {

  private StaticUtility() {
    // prevent instantiation.
    throw new AssertionError();
  }
}
