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
    ArrayDeque<TreeNode> stack;
    public boolean isBalanced(TreeNode root) {
        int e = dfsHelper(root);

        if ( e >= 0) {
            return true;
        }
        return false;
    }

    public int dfsHelper(TreeNode curr) {
        if (curr == null) {
            return 0;
        }

        int leftRes = dfsHelper(curr.left);
        if(leftRes < 0) {
            return -1;
        }
        int rightRes = dfsHelper(curr.right);
        if(rightRes < 0) {
            return -1;
        }
        if (Math.abs(leftRes - rightRes) > 1) {
            return -1;
        }

        int maxHeight = Math.max(leftRes, rightRes);

        return maxHeight + 1;
    }
}