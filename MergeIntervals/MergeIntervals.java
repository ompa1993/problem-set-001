package MergeIntervals;
/*
* Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.

Example 1:

Intervals: [[1,4], [2,5], [7,9]]
Output: [[1,5], [7,9]]
Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
one [1,5].
*
*
* Example 2:

Intervals: [[6,7], [2,4], [5,9]]
Output: [[2,4], [5,9]]
Explanation: Since the intervals [6,7] and [5,9] overlap, we merged them into one [5,9].

Example 3:

Intervals: [[1,4], [2,6], [3,5]]
Output: [[1,6]]
Explanation: Since all the given intervals overlap, we merged them into one.
*
* The diagram above clearly shows a merging approach. Our algorithm will look like this:

Sort the intervals on the start time to ensure a.start <= b.start
If ‘a’ overlaps ‘b’ (i.e. b.start <= a.end), we need to merge them into a new interval ‘c’ such that:
    c.start = a.start
    c.end = max(a.end, b.end)
We will keep repeating the above two steps to merge ‘c’ with the next interval if it overlaps with ‘c’.
* */

import java.util.*;

class Interval {
    int start;
    int end;

    public Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}
public class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals){
        if (intervals.size() < 2){
            return intervals;
        }

        //sort the intervals by their starting index
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));

        List<Interval> mergedIntervals = new LinkedList<Interval>();
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next();
        int start = interval.start;
        int end = interval.end;

        while (intervalItr.hasNext()){
            interval = intervalItr.next();
            if (interval.start <= end) { //overlapping intervals, adjust the end
                end = Math.max(end, interval.end);
            }else{ //non-overlapping intervals, add it to the merged intervals list
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        //add the last one
        mergedIntervals.add(new Interval(start, end));
        return mergedIntervals;
    }


    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
        /*
        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();*/
    }
}
