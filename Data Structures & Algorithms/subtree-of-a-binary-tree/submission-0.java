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
    ArrayDeque<TreeNode> stack = new ArrayDeque<>();
    ArrayDeque<TreeNode> stack2 = new ArrayDeque<>();
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        stack.addFirst(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.val == subRoot.val) {
                stack2.addFirst(curr);
            }
            if (curr.left != null) {
                stack.addFirst(curr.left);
            }
            if (curr.right != null) {
                stack.addFirst(curr.right);
            }
        }

        while (!stack2.isEmpty()) {
            if (dfsHelper(stack2.pop(), subRoot)) {
                return true;
            };
        }
        return false;
    }

    public boolean dfsHelper(TreeNode node, TreeNode comp) {
        if (node == null && comp == null) {
            return true;
        }

        if ((node == null && comp != null) || (node != null && comp == null)) {
            return false;
        }

        return node.val == comp.val && dfsHelper(node.left, comp.left)
            && dfsHelper(node.right, comp.right);
    }
}
