/*
Remove Linked List Elements

Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
*/
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
    public ListNode removeElements(ListNode h, int val) {
        if(h == null) return h;
        ListNode t = new ListNode(-1);
        t.next = h;
        h = t;
        while(t.next != null) {
            if(t.next.val == val) t.next = t.next.next;
            else t = t.next;
        }
        return h.next;
    }
}
