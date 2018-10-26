package test.hp.leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import test.hp.leetcode.OverlapIntervals.Interval;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.
Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * @author hp
 *
 */
public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		intervals.add(newInterval);
		intervals.sort(Comparator.comparingInt(o->o.start));
		LinkedList<Interval> merged = new LinkedList<>();
		for(Interval interval: intervals) {
			if (merged.isEmpty() || merged.getLast().end < interval.start) {
				merged.add(interval);
			}else {
				merged.getLast().end = Math.max(merged.getLast().end, interval.end);
			}
		}
        return merged;
    }
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
}
