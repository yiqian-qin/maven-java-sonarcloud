import java.util.*;
import java.util.Arrays;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        // Return empty list if root is null.
        if (root == null) {
            return paths;
        }
        // Call the helper method dfs to traverse the tree and generate the paths from root to leaves.
        dfs(root, "", paths);
        return paths;
    }
    // Define a helper method dfs with 3 parameters: current node, current path, and a list of paths.
    private void dfs(TreeNode node, String path, List<String> paths) {
        // Update the current path by adding the current node's value.
        path += node.val;
        // If the current node is a leaf, add the path to the list of paths.
        if (node.left == null && node.right == null) {
            paths.add(path);
            return;
        }
        // If the current node is not a leaf, add "->" to the current path and call dfs on the left and right children.
        if (node.left != null) {
            dfs(node.left, path + "->", paths);
        }
        if (node.right != null) {
            dfs(node.right, path + "->", paths);
        }
    }
}
