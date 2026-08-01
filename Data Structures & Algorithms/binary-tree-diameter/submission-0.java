/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    int max;
    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return 0;
        }
        max = 0;
        diameterHelper(root);
        return max;
        
    }

    public int diameterHelper(TreeNode next) {
        if (next == null) {
            return 0;
        }

        int right = next.right != null ? 1 + diameterHelper(next.right) : 0;
        int left = next.left != null ? 1 + diameterHelper(next.left) : 0;
        max = Math.max(max, right + left);
        return Math.max(right, left);

    }
}
