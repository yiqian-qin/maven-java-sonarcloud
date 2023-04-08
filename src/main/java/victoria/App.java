import java.util.*;
import java.util.Arrays;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
 
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        // Call the helper function
        return constructBST(nums, 0, nums.length - 1);
    }
    
    // Helper function to construct the BST recursively
    private TreeNode constructBST(int[] nums, int left, int right) {
        // Base case: returned when the left index is greater than the right index
        if (left > right) {
            return null;
        }
        
        // Calculate the mid index
        int mid = (left + right) / 2;
        
        // Construct a new TreeNode with val = the value of the mid index
        TreeNode current = new TreeNode(nums[mid]);
        
        // Recursively call the helper function to construct the left and right subtrees respectively
        current.left = constructBST(nums, left, mid - 1);
        current.right = constructBST(nums, mid + 1, right);
        
        // Return the constructed TreeNode
        return current;
    }
}
