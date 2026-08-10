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
        int[] e = dfsHelper(root);

        if (e[0] == 1) {
            return true;
        }
        return false;
    }

    public int[] dfsHelper(TreeNode curr) {
        if (curr == null) {
            return new int[] {1, 0};
        }

        int[] leftRes = dfsHelper(curr.left);
        int[] rightRes = dfsHelper(curr.right);
        System.out.println("at node " + curr.val + " with left height: " + leftRes[1]
            + " right height" + rightRes[1]);

        int maxHeight = Math.max(leftRes[1], rightRes[1]);
        int balanced = 0;

        if (Math.abs(leftRes[1] - rightRes[1]) <= 1 && leftRes[0] == 1 && rightRes[0] == 1) {
            balanced = 1;
        }

        return new int[] {balanced, maxHeight + 1};
    }
}
