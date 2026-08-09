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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        if (head.next == null) {
            return null;
        }
        ListNode nthNode = dummy;

        while (n > 0) {
            nthNode = nthNode.next;
            n--;
        }

        ListNode backNode = dummy;

        while(nthNode.next != null) {
            nthNode = nthNode.next;
            backNode = backNode.next;
        }

        backNode.next = backNode.next.next;
        return dummy.next;

    }
}
