import java.util.*;
import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int left = 1;
        int right = position[n-1] - position[0];
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(mid, position, m)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    
    private boolean check(int minDistance, int[] position, int m) {
        int count = 1;
        int lastPos = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPos >= minDistance) {
                count++;
                lastPos = position[i];
            }
        }
        return count >= m;
    }
}
