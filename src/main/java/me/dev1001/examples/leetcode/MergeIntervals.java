package me.dev1001.examples.leetcode;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Created by hongzong.li on 5/26/17.
 */
public class MergeIntervals {

  public static List<Interval> mergeIntervals(List<Interval> origins) {
    Objects.requireNonNull(origins);
    if (origins.size() <= 1) {
      return origins;
    }

    origins.sort(Comparator.comparing(Interval::getBegin));
    List<Interval> result = new ArrayList<>();

    Interval current = origins.get(0);
    for (int i = 1; i < origins.size(); i++) {
     Interval interval = origins.get(i);
     if (interval.begin > current.end) {
       result.add(current);
       current = interval;
     } else if (interval.end > current.end) {
       current = new Interval(current.begin, interval.end);
     }
    }
    result.add(current);
    return result;
  }

  public static void main(String[] args) {
    List<Interval> intervals = Arrays.asList(
        new Interval(1, 3),
        new Interval(2, 6),
        new Interval(8, 10),
        new Interval(15, 18)
    );
    System.out.println(mergeIntervals(intervals));
  }

  static final class Interval {
    private final int begin;
    private final int end;

    public Interval(int begin, int end) {
      checkArgument(begin < end);
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
  }
}
