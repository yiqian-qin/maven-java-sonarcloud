import java.util.*;
import java.util.Arrays;
 
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int l = 1;
        int r = m * n;
        while (l < r) {
            int mid = (l + r) / 2;
            int count = 0;
            for (int i = 1; i <= m; i++) {
                count += Math.min(mid / i, n);
            }
            if (count < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
        
    }
}
