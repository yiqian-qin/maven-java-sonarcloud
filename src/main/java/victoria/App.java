import java.util.*;
import java.util.Arrays;
 
class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        double[][] dp = new double[t+1][n+1];
        dp[0][1] = 1.0; //initializing position of the frog at the beginning
        
        for(int i=1; i<=t; i++) {
            for(int j=1; j<=n; j++) {
                for(int[] edge: edges) {
                    int u = edge[0], v = edge[1];
                    if(u==j || v==j) { //checking if the current node is vertex of the current edge
                        int neighbor = (u==j) ? v : u;
                        if(dp[i-1][j] > 0) { //checking if there is already some probability of reaching the node
                            dp[i][neighbor] += dp[i-1][j]/(edge.length-1); //adding probability to neighbor
                        }
                    }
                }
                if(i==t && j==target) return dp[t][target]; //returning the required probability for target node, if last second is reached and checking for target
            }
        }
        return 0.0; //if there is no probability of reaching the target node, then returning 0.0
    }
}
