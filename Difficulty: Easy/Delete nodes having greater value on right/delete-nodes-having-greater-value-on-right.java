//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class LinkedList {

    /* Function to print linked list */
    public static void print(Node root) {
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    /* Driver program to test above functions */
    public static void main(String args[]) throws IOException {

        /* Constructed Linked List is 1.2.3.4.5.6.
         7.8.8.9.null */
        int value;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t > 0) {

            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node copy = head;
            for (int i = 1; i < s.length; i++) {
                Node temp = new Node(Integer.parseInt(s[i]));
                copy.next = temp;
                copy = copy.next;
            }
            Solution ob = new Solution();
            Node result = ob.compute(head);
            print(result);
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends



/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution 
{
    Node compute(Node head) 
    {
        // Step 1: Reverse the original list
        Node rev_head = reverse(head);
        
        // Step 2: Process the reversed list and keep track of the max value seen so far
        Node dummy = new Node(-1); // Dummy node for easier list manipulation
        Node temp = dummy;
        int max = Integer.MIN_VALUE; // Initialize max to the smallest possible value
        
        while (rev_head != null) 
        {
            if (rev_head.data >= max) 
            {
                // Only add the node if its value is greater than or equal to the current max
                max = rev_head.data;
                temp.next = rev_head; // Reuse the node directly
                temp = temp.next;
            }
            rev_head = rev_head.next;
        }
        
        // Step 3: Finalize the new list by setting the next pointer of the last node to null
        temp.next = null;

        // Step 4: Reverse the list again to restore the original order
        return reverse(dummy.next);
    }
    
    Node reverse(Node head) 
    {
        Node prev = null;
        while (head != null) 
        {
            Node nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
}
