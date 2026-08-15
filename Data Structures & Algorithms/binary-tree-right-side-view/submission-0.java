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
    // recur on right side, if height index doesn't have a value add value
    // get return from right side, if return is null recur on left?
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {

        if(root == null) {
            return res;
        }
        recur(0, root);
        return res;
    }

    public void recur(int height, TreeNode root) {
        if (root == null) {
            return;
        };

        if (height >= res.size()) {
            while (height >= res.size()) {
                res.add(null);
            }
        }
        if (res.get(height) == null) {
            res.set(height, root.val);
        }
        recur(height + 1, root.right);
        recur(height + 1, root.left);
    }
}
