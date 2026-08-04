/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {

        if ( head == null || head.next == null) {
            return false;
        }

        ListNode pt1 = head;
        ListNode pt2 = head;

        while (pt1 != null && pt2 != null) {
            pt1 = pt1.next;
            if(pt2.next != null) {
                pt2 = pt2.next.next;
            } else {
                pt2 = null;
            }
            if (pt1 == pt2) {
                return true;
            }

        }

        return false;
        
    }
}
