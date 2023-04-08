import java.util.*;
import java.util.Arrays;
 
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int curMax = 0;
        int curMin = 0;
        for (int num : nums) {
            curMax = Math.max(curMax + num, num);
            max = Math.max(max, curMax);
            curMin = Math.min(curMin + num, num);
            min = Math.min(min, curMin);
            sum += num;
        }
        return max > 0 ? Math.max(max, sum - min) : max;
        
    }
}
