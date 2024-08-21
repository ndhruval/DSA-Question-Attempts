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
    public ListNode removeNodes(ListNode head) 
    {
        if (head == null) return null;
        
        // Reverse the list first
        ListNode reversedHead = reverse(head);
        
        // Create a new head for the filtered list
        ListNode newHead = new ListNode();
        ListNode current = newHead;
        int max = Integer.MIN_VALUE;

        while (reversedHead != null) 
        {
            if (reversedHead.val >= max) 
            {
                current.next = new ListNode(reversedHead.val);
                current = current.next;
                max = reversedHead.val;
            }
            reversedHead = reversedHead.next;
        }

        // Reverse the list again to restore original order
        return reverse(newHead.next);
    }

    public ListNode reverse(ListNode head) 
    {
        ListNode prev = null;
        while (head != null) 
        {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
}
