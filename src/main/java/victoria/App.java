import java.util.*;
import java.util.Arrays;
 
class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        for (int i = 0; i < n; i++) {
            char c = formula.charAt(i);
            if (c == '(') {
                stack.push(new HashMap<>());
            } else if (c == ')') {
                Map<String, Integer> top = stack.pop();
                int iStart = ++i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplier = iStart < i ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                for (String key : top.keySet()) {
                    int v = top.get(key);
                    stack.peek().put(key, stack.peek().getOrDefault(key, 0) + v * multiplier);
                }
                i--;
            } else {
                int iStart = i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String name = formula.substring(iStart, i);
                iStart = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int count = iStart < i ? Integer.parseInt(formula.substring(iStart, i)) : 1;
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + count);
                i--;
            }
        }
        Map<String, Integer> map = stack.pop();
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (String key : list) {
            sb.append(key);
            int v = map.get(key);
            if (v > 1) {
                sb.append(v);
            }
        }
        return sb.toString();
        
    }
}
