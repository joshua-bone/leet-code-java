/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         return addAndCarry(l1, l2, 0);
    }
    
    public ListNode addAndCarry(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            return carry == 0 ? null : new ListNode(carry);
        }
        int val1 = (l1 == null) ? 0 : l1.val;
        int val2 = (l2 == null) ? 0 : l2.val;
        ListNode child1 = (l1 == null) ? null : l1.next;
        ListNode child2 = (l2 == null) ? null : l2.next;
        int sum = val1 + val2 + carry;
        ListNode localHead = new ListNode(sum % 10);
        localHead.next = addAndCarry(child1, child2, sum / 10);
        return localHead;
    }
}
