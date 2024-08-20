/**
 * Definition for singly-linked list.
 * public class ListNode {
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
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) 
    {
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        int count1=0, count2=0;
        ListNode ans = null;
        while(temp1 != null)
        {
            count1++;
            temp1 = temp1.next;
        }
        while(temp2 != null)
        {
            count2++;
            temp2 = temp2.next;
        }
        if(count1 > count2)
        {
            int loop1 = count1 - count2;
            for(int i=1;i<= loop1;i++)
            {
            head1 = head1.next;
            }
            
        }
        if(count2 > count1)
        {
            int loop2 = count2 - count1;
            for(int i=1;i<= loop2;i++)
            {
            head2 = head2.next;
            }
            
        }
        ans = comparison(head1, head2);
        return ans;
        
        
        // code here
    }
    ListNode comparison(ListNode head1, ListNode head2)
    {
        if(head1 == null || head2 == null)
        return null;
        while(head1 != null && head2 != null)
        {
            if(head1 == head2)
            return head1;
            
            head1 = head1.next;
            head2 = head2.next;
            
        }
        return null;
    }
}