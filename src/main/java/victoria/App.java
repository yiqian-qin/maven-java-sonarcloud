import java.util.*;
import java.util.Arrays;
 
class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currString = new StringBuilder();
        int currCount = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                currCount = currCount * 10 + c - '0';
            } else if(c == '['){
                countStack.push(currCount);
                stringStack.push(currString);
                currString = new StringBuilder();
                currCount = 0;
            } else if(c == ']'){
                StringBuilder temp = currString;
                currString = stringStack.pop();
                for(int i = countStack.pop(); i > 0; i--){
                    currString.append(temp);
                }
            } else {
                currString.append(c);
            }
        }
        return currString.toString();
    }
}
