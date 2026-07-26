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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode iter = null;
        ListNode head = null;
        ListNode toSet = null;

        while(list1 != null && list2 != null) {
            System.out.println(iter);
            if(list1.val > list2.val) {
                toSet = list2;
                list2 = list2.next;
            } else {
                toSet = list1;
                list1 = list1.next;
            }
            if(head == null) {
                head = toSet;
                iter = head;
            } else {
            iter.next = toSet;
            iter = iter.next;
            }
        }
        if(iter == null) {
           head = (list1 != null) ? list1 : list2;
        } else if(list1 != null) {
            iter.next = list1;
        } else {
            iter.next = list2;
        }
        return head;
    }
}