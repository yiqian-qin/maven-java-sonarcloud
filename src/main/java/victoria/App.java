import java.util.*;
import java.util.Arrays;
 
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) { // if the power is zero, return 1
            return 1;
        } 
        if (n < 0) { // if the power is negative, calculate pow(x,-n) and return 1/pow(x,-n)
            return 1 / myPow(x, -n);
        }
        double res = myPow(x, n/2); // calculating the result by dividing the problem into subproblems and using recursion
        if (n % 2 == 0) { // if n is even, use the formula x^n = (x^(n/2))^2
            res = res * res;
        } else { // else use the formula x^n = x * (x^(n/2))^2
            res = x * res * res;
        }
        return res;
    }
}
