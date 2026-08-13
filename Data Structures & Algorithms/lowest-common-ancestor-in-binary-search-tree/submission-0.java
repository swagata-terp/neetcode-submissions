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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recur(root, p.val, q.val);

        
    }

    private TreeNode recur(TreeNode root, int p, int q) {

        if (root.val > q && root.val > p) {
            return recur(root.left, p, q);
        }
        if (root.val < q && root.val < p) {
            return recur(root.right, p , q);
        }
        if ((root.val == q || root.val == p)) {
            return root;
        }
        return root;

        // if ((root.val > p && root.val  < q) || (root.val > q && root.val  < p)) {
        //     return root;
        // }
    }
}
