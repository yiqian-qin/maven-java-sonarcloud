import java.util.*;
import java.util.Arrays;

class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        long i = 1;
        while (i <= n) {
            long divider = i * 10;
            count += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0L), i);
            i *= 10;
        }
        return count;
    }
}
