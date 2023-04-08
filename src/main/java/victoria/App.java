import java.util.*;
import java.util.Arrays;
 
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;
        for(int i = 0; i < timeSeries.length; i++){
            if(i == timeSeries.length-1){
                total += duration;
            }else{
                total += Math.min(timeSeries[i+1] - timeSeries[i], duration);
            }
        }
        return total;

    }
}
