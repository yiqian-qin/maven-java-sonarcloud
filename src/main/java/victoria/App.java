import java.util.*;
import java.util.Arrays;
 
class Solution {
    public boolean validWordSquare(List<String> words) {
        int n = words.size();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < words.get(i).length(); j++){
                if(j >= n || i >= words.get(j).length() || words.get(i).charAt(j) != words.get(j).charAt(i)) return false;
            }
        }
        return true;
        
    }
}
