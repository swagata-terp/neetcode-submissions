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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode dummy =  new ListNode(0);                                             
        ListNode newHead = dummy;
        int carry = 0;
        while (head1 != null || head2 != null || carry > 0) {
            int curr1 = 0;
            int curr2 = 0;
            if (head1 != null) {
                curr1 = head1.val;
                head1 = head1.next;
            }

            if(head2 != null) {
                curr2 = head2.val;
                head2 = head2.next;
            }
            int res = curr1 + curr2 + carry;
            if (res >= 10) {
                res -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            ListNode curr = new ListNode(res);
            newHead.next = curr;
            newHead = curr;
            
            

        }
        return dummy.next;
        
    }
}
