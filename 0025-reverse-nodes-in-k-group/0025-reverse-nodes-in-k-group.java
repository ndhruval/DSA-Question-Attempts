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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        int count =0;

        while(temp!= null && count<k)
        {
            temp = temp.next;
            count++;
        }
        if(count == k)
        {
            ListNode prev = null;
            ListNode curr = head;
            ListNode next = null;
            int i=0;

            while(curr != null && i<k)
            {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                i++;
            }

            head.next = reverseKGroup(curr,k);
            return prev;
        }
        return head;
    }
}