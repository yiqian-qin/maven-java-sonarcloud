import java.util.*;
import java.util.Arrays;

class Solution {
    int minDiff = Integer.MAX_VALUE; // initialize the minimum difference as maximum integer value
    Integer prev = null; // initialize previous node value as null
    
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return minDiff; // if the BST is null, return the current minimum difference
        getMinimumDifference(root.left); // traverse left subtree
        if (prev != null) minDiff = Math.min(minDiff, root.val - prev); // check and update the minimum difference
        prev = root.val; // set previous node value as current node value
        getMinimumDifference(root.right); // traverse right subtree
        return minDiff; // return the final minimum difference
    }
}
