/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution 
{
    public ListNode detectCycle(ListNode head) 
    {
        if(head == null)
            return null;

        ListNode slow = head;
        ListNode intersect = intersection(head);
        if(intersect == null)
        return null;
        
        while(slow != intersect)
        {
        slow = slow.next;
        intersect= intersect.next;
        }
        return slow;


        
        
    }
    public ListNode intersection(ListNode head)
    {
        if(head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null)
        {
            fast = fast.next;
            if(fast != null)
            fast = fast.next;
            slow = slow.next;
            if(slow == fast)
            {
                return slow;
            }
            
            

        }
        return null;
    }
}