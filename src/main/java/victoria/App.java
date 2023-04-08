import java.util.*;
import java.util.Arrays;
 
class Solution {
    public int[] sortEvenOdd(int[] nums) {
        int[] odd = new int[nums.length];
        int[] even = new int[nums.length];
        int oddCount = 0;
        int evenCount = 0;
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0){
                even[evenCount] = nums[i];
                evenCount++;
            }else{
                odd[oddCount] = nums[i];
                oddCount++;
            }
        }
        Arrays.sort(odd, 0, oddCount);
        Arrays.sort(even, 0, evenCount);
        int[] result = new int[nums.length];
        int oddIndex = oddCount - 1;
        int evenIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0){
                result[i] = even[evenIndex];
                evenIndex++;
            }else{
                result[i] = odd[oddIndex];
                oddIndex--;
            }
        }
        return result;

    }
}
