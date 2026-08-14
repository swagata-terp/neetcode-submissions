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
    
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        int height = 0;
        recur(0, root);
        return res;
        
    }

    public void recur(int height, TreeNode node) {
        if (node == null) {
            return;
        }
        if(height >= res.size()) {
            while(height >= res.size())
            res.add(height, new ArrayList<>());
        }
        
        res.get(height).add(node.val);

        recur(height + 1, node.left);
        recur(height + 1, node.right);
    }
}
