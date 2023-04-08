import java.util.*;
import java.util.Arrays;
 
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while(i < name.length() && j < typed.length()){
            if(name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }else if(j > 0 && typed.charAt(j) == typed.charAt(j - 1)){
                j++;
            }else{
                return false;
            }
        }
        if(i < name.length()) return false;
        while(j < typed.length()){
            if(typed.charAt(j) != typed.charAt(j - 1)) return false;
            j++;
        }
        return true;

    }
}
