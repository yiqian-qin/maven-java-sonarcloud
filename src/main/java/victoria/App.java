import java.util.*;
import java.util.Arrays;
 
class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int result = 0;
        for(int i = 0; i < n; i++){
            if(Character.isDigit(s.charAt(i))){
                int num = s.charAt(i) - '0';
                while(i + 1 < n && Character.isDigit(s.charAt(i + 1))){
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                result += sign * num;
            }
            else if(s.charAt(i) == '+'){
                sign = 1;
            }
            else if(s.charAt(i) == '-'){
                sign = -1;
            }
            else if(s.charAt(i) == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            else if(s.charAt(i) == ')'){
                result = result * stack.pop() + stack.pop();
            }
        }
        return result;
        
    }
}
