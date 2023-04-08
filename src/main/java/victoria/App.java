import java.util.*;
import java.util.Arrays;
 
class Solution {
    public int minSwaps(String s) {
        int n = s.length();
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                count0++;
            } else {
                count1++;
            }
        }
        if (Math.abs(count0 - count1) > 1) {
            return -1;
        }
        if (count0 > count1) {
            int res = 0;
            for (int i = 0; i < n; i += 2) {
                if (s.charAt(i) == '1') {
                    res++;
                }
            }
            return res;
        } else if (count0 < count1) {
            int res = 0;
            for (int i = 0; i < n; i += 2) {
                if (s.charAt(i) == '0') {
                    res++;
                }
            }
            return res;
        } else {
            int res1 = 0;
            int res2 = 0;
            for (int i = 0; i < n; i += 2) {
                if (s.charAt(i) == '1') {
                    res1++;
                }
            }
            for (int i = 0; i < n; i += 2) {
                if (s.charAt(i) == '0') {
                    res2++;
                }
            }
            return Math.min(res1, res2);
        }
        
    }
}
