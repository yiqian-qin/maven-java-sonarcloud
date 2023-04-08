import java.util.*;
import java.util.Arrays;

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> merged = new ArrayList<>();
        for (List<Interval> intervals : schedule) {
            merged.addAll(intervals);
        }
        Collections.sort(merged, (a, b) -> a.start - b.start);

        List<Interval> result = new ArrayList<>();
        int end = merged.get(0).end;
        for (Interval interval : merged) {
            if (interval.start > end) {
                result.add(new Interval(end, interval.start));
            }
            end = Math.max(end, interval.end);
        }
        return result;
    }
}
