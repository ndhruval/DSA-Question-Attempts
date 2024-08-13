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
class Solution 
{
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        ListNode x = head;
        int d=0;
        while(x != null)
        {
            x = x.next;
            d++;
        }
        
        int begin = d - n ;
        if (begin == 0) 
        {
            return head.next;
        }
        
        
        ListNode temp = head;
        for(int i=1;i< begin;i++)
        {
            
            temp = temp.next;
        }
        
       temp.next = temp.next.next;
        
        return head;
        
        
    }
}