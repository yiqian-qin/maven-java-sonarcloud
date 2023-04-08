import java.util.*;
import java.util.Arrays;

class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int[] dp = new int[m]; // to store longest common subsequence
        Arrays.fill(dp, 1); // intialize the array with 1s
        
        for(int j=1; j<m; j++) {
            // compare each column with previous column
            for(int i=0; i<j; i++) {
                boolean isSorted = true;
                // compare each row
                for(int k=0; k<n; k++) {
                    if(strs[k].charAt(i) > strs[k].charAt(j)) {
                        isSorted = false;
                        break;
                    }
                }
                if(isSorted) {
                    dp[j] = Math.max(dp[j], dp[i]+1);
                }
            }
        }
        return m - Arrays.stream(dp).max().getAsInt(); // return the columns that are not part of longest common subsequence
    }
}
