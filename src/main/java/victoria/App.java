import java.util.*;
import java.util.Arrays;
 
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += rolls[i];
        }
        int total = (m + n) * mean;
        int missing = total - sum;
        if (missing < n || missing > 6 * n) {
            return new int[0];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = 1;
        }
        missing -= n;
        for (int i = n - 1; i >= 0; i--) {
            int add = Math.min(5, missing);
            res[i] += add;
            missing -= add;
        }
        return res;
        
    }
}
