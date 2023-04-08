import java.util.*;
import java.util.Arrays;
 
class Solution {
    public int[] constructRectangle(int area) {
        int[] ans = new int[2];
        int w = (int)Math.sqrt(area);
        while(area % w != 0) w--;
        ans[0] = area / w;
        ans[1] = w;
        return ans;

    }
}
