import java.util.*;
import java.util.Arrays;

class SummaryRanges {

    List<int[]> intervals; // List to store intervals

    public SummaryRanges() {
        intervals = new ArrayList<>();
    }

    public void addNum(int val) {
        int n = intervals.size();
        if (n == 0) { //if interval list is empty
            intervals.add(new int[]{val, val});
            return;
        }
        // check if val is lesser than first start in interval list
        if (intervals.get(0)[0] > val) {
            if (intervals.get(0)[0] == val + 1) {
                intervals.get(0)[0] = val;
            } else {
                intervals.add(0, new int[]{val, val});
            }
            return;
        }
        // check if val lies in a middle interval
        for (int i = 0; i < n-1;i++) {
            int start = intervals.get(i)[0];
            int end = intervals.get(i)[1];
            if (start <= val && end >= val) return; //if val is already in an interval
            int nextStart = intervals.get(i+1)[0];
            if (end < val && nextStart > val) {
                if (end + 1 == val && nextStart - 1 == val) {
                    intervals.get(i)[1] = intervals.remove(i+1)[1];
                } else if (end + 1 == val) {
                    intervals.get(i)[1] = val;
                } else if (nextStart - 1 == val) {
                    intervals.get(i+1)[0] = val;
                } else {
                    intervals.add(i+1, new int[]{val, val});
                }
                return;
            }
        }
        int[] last = intervals.get(n-1);
        // check if val is greater than last end in interval list
        if (last[1] < val) {
            if (last[1] == val - 1) {
                last[1] = val;
            } else {
                intervals.add(new int[]{val, val});
            }
            return;
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[intervals.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = intervals.get(i);
        }
        return res;
    }
}
