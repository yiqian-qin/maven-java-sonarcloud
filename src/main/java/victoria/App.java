import java.util.*;
import java.util.Arrays;
 
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int res = 0;
        int n = costs.length / 2;
        int[] diff = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            diff[i] = costs[i][0] - costs[i][1];
            res += costs[i][1];
        }
        Arrays.sort(diff);
        for (int i = 0; i < n; i++) {
            res += diff[i];
        }
        return res;
        
        
    }
}
