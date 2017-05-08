package me.dev1001.examples.lang.escape;

/**
 * Created by hongzong.li on 5/8/17.
 */
public class ThisEscape {
  private final int num;

  public ThisEscape(EventSource eventSource) {
    eventSource.register(event -> detectEscape());
    this.num = 1;
  }

  private void detectEscape() {
    if (num != 1) {
      System.out.println("This escape detected!!!");
    }
  }

  public static void main(String[] args) {
    EventSource eventSource = new EventSource();
    eventSource.start();
    while (true) {
      new ThisEscape(eventSource);
    }
  }

}
