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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        int count = 0;
        while(temp.next != null){
            count++;
            temp = temp.next;
        }
        count++;
        temp.next = head;
        k = k%count;
        int d = count - k;
        ListNode dummy = head;
        int i=1;
        while(i<d){
            dummy = dummy.next;
            i++;
        }
        ListNode newhead = dummy.next;
        dummy.next = null;
        return newhead;

        
    }
}