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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            
            // Move `temp` forward while there are duplicates
            while (temp != null && temp.val == curr.val) {
                temp = temp.next;
            }
            
            // Link `curr.next` to the first non-duplicate node
            curr.next = temp;
            
            // Move `curr` forward
            curr = curr.next;
        }
        return head;
    }
}
