import java.util.*;
import java.util.Arrays;

class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int width = (1 << height) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                row.add("");
            }
            res.add(row);
        }
        fill(root, res, 0, 0, width - 1);
        return res;
    }
    
    private void fill(TreeNode root, List<List<String>> res, int level, int left, int right) {
        if (root == null) {
            return;
        }
        int mid = left + (right - left) / 2;
        res.get(level).set(mid, Integer.toString(root.val));
        fill(root.left, res, level + 1, left, mid - 1);
        fill(root.right, res, level + 1, mid + 1, right);
    }
    
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
