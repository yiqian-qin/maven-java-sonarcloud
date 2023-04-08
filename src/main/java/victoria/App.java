import java.util.*;
import java.util.Arrays;
 
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> res = new ArrayList<>();
        List<Interval> all = new ArrayList<>();
        for (List<Interval> list : schedule) {
            all.addAll(list);
        }
        Collections.sort(all, (a, b) -> a.start - b.start);
        int end = all.get(0).end;
        for (int i = 1; i < all.size(); i++) {
            if (all.get(i).start > end) {
                res.add(new Interval(end, all.get(i).start));
                end = all.get(i).end;
            } else {
                end = Math.max(end, all.get(i).end);
            }
        }
        return res;
    }
}
