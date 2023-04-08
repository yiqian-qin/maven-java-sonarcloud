import java.util.*;
import java.util.Arrays;
 
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = i; k <= m; k++) {
                    for (int l = j; l <= n; l++) {
                        if (sum[k][l] - sum[i - 1][l] - sum[k][j - 1] + sum[i - 1][j - 1] == target) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
