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
    Deque<TreeNode> pStack = new ArrayDeque<>();
    Deque<TreeNode> qStack = new ArrayDeque<>();
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        }

        if (p == null && q == null) {
            return true;
        }
        pStack.addFirst(p);
        qStack.addFirst(q);

        while (!pStack.isEmpty() && !qStack.isEmpty()) {
            TreeNode pcurr = pStack.pop();
            TreeNode qcurr = qStack.pop();

            if ((pcurr == null && qcurr != null) || (pcurr != null && qcurr == null)) {
                return false;
            }
            if ((pcurr.left == null && qcurr.left != null)
                || (pcurr.left != null && qcurr.left == null)) {
                return false;
            }
            if ((pcurr.right == null && qcurr.right != null)
                || (pcurr.right != null && qcurr.right == null)) {
                return false;
            }

            if (pcurr.val != qcurr.val) {
                return false;
            }
            if (pcurr.right != null) {
                pStack.addFirst(pcurr.right);
                qStack.addFirst(qcurr.right);
            }
            if (pcurr.left != null) {
                pStack.addFirst(pcurr.left);
                qStack.addFirst(qcurr.left);
            }
        }
        return true;
    }
}
