package me.dev1001.examples.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by hongzong.li on 5/26/17.
 */
public class InsertInterval {

  public static List<Interval> insertInterval(List<Interval> intervals, Interval target) {
    Objects.requireNonNull(intervals);
    Objects.requireNonNull(target);

    if (intervals.isEmpty()) {
      return Collections.singletonList(target);
    }

    List<Interval> result = new ArrayList<>();
    for (Interval interval : intervals) {
      if (interval.end < target.begin) {
        result.add(interval);
      } else if (target.end < interval.begin) {
        result.add(target);
        target = interval;
      } else {
        target = new Interval(
            Math.min(target.begin, interval.begin),
            Math.max(target.end, interval.end));
      }
    }
    result.add(target);
    return result;
  }

  static final class Interval {

    int begin;
    int end;

    public Interval(int begin, int end) {

      this.begin = begin;
      this.end = end;
    }

    public int getBegin() {
      return begin;
    }

    public int getEnd() {
      return end;
    }

    @Override
    public String toString() {
      return "[" + begin + ", " + end + "]";
    }

    public static void main(String[] args) {
      List<Interval> intervals = Arrays.asList(
          new Interval(1, 2),
          new Interval(3, 5),
          new Interval(7, 8),
          new Interval(9, 10)
      );
      System.out.println(insertInterval(intervals, new Interval(2, 4)));
    }
  }
}
