import java.util.*;
import java.util.Arrays;
 
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean xFound = false;
            boolean yFound = false;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.val == x) xFound = true;
                if(node.val == y) yFound = true;
                if(node.left != null && node.right != null){
                    if(node.left.val == x && node.right.val == y) return false;
                    if(node.left.val == y && node.right.val == x) return false;
                }
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(xFound && yFound) return true;
            if(xFound || yFound) return false;
        }
        return false;

    }
}
