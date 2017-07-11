package me.dev1001.examples.concurrent;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author hongzong.li
 */
public class PhaserExample {
  public static void main(String[] args) {
    Phaser phaser = new Phaser() {
      @Override
      protected boolean onAdvance(int phase, int registeredParties) {
        return phase >= 3 || registeredParties == 0;
      }
    };

    phaser.register();
    printPhaserState(phaser);
    List<Runnable> tasks = createTasks(phaser, 3);
    for (Runnable task : tasks) {
      phaser.register();
      new Thread(() -> {
        while (!phaser.isTerminated()) {
          System.out.println("Executing tasks in phase " + phaser.getPhase());
          task.run();
        }
      }).start();
    }
    printPhaserState(phaser);
    phaser.arriveAndDeregister();
    printPhaserState(phaser);

  }


  private static void printPhaserState(Phaser phaser) {
    System.out.println("====================Phaser State=====================");
    System.out.println("Arrived parties: " + phaser.getArrivedParties());
    System.out.println("Unarrived parties: " + phaser.getUnarrivedParties());
    System.out.println("=====================================================");
  }

  private static List<Runnable> createTasks(Phaser phaser, int num) {
    return IntStream.range(0, num)
        .mapToObj(seq -> (Runnable) () -> {
          Uninterruptibles.sleepUninterruptibly((1 + seq), TimeUnit.SECONDS);
          if (seq == 1) {
           phaser.arriveAndDeregister();
          } else {
            phaser.arriveAndAwaitAdvance();
          }
          System.out.println("Executing Task" + seq);
        })
        .collect(Collectors.toList());
  }
}
