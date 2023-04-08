import java.util.*;
import java.util.Arrays;

class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return dfs(dp, boxes, 0, n - 1, 0);
    }
    
    private int dfs(int[][][] dp, int[] boxes, int i, int j, int k) {
        if (i > j) return 0;
        if (dp[i][j][k] > 0) return dp[i][j][k];
        int res = (k + 1) * (k + 1) + dfs(dp, boxes, i + 1, j, 0);
        for (int m = i + 1; m <= j; ++m) {
            if (boxes[m] == boxes[i]) {
                res = Math.max(res, dfs(dp, boxes, i + 1, m - 1, 0) + dfs(dp, boxes, m, j, k + 1));
            }
        }
        dp[i][j][k] = res;
        return res;
    }
}
