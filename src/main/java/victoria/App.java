import java.util.*;
import java.util.Arrays;
 
class Solution {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        int max = 0;
        int index = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (heights[i] > max) {
                res[index--] = i;
                max = heights[i];
            }
        }
        int[] ans = new int[n - index - 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = res[index + 1 + i];
        }
        return ans;
        
    }
}
