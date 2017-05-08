package me.dev1001.examples.lang.escape;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by hongzong.li on 5/8/17.
 */
public class EventSource extends Thread {

  private LinkedBlockingQueue<EventListener> eventListeners = new LinkedBlockingQueue<>();

  @Override
  public void run() {
    while (true) {
      try {
        eventListeners.take().onEvent(null);
      } catch (InterruptedException e) {
        break;
      }
    }
  }

  public void register(EventListener listener) {
    eventListeners.add(listener);
  }
}
