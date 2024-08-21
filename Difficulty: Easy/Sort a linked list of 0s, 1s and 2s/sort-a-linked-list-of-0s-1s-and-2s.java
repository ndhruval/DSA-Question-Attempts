//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends
// User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution 
{
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) 
    {
        int cnt[] = new int[3];
        int l =0;
        while(head != null)
        {
            if(head.data == 0)
            cnt[0]++;
            else if(head.data == 1)
            cnt[1]++;
            else
            cnt[2]++;
            l++;
            head = head.next;
        }
        Node dummy = new Node(-1);
        Node temp = dummy;
        
        for( int i =1;i<=cnt[0];i++)
        {
            Node New = new Node(0);
            temp.next= New;
            temp = temp.next;
            
        }
        for( int i =1;i<=cnt[1];i++)
        {
            Node New = new Node(1);
            temp.next= New;
            temp = temp.next;
            
        }
        for( int i =1;i<=cnt[2];i++)
        {
            Node New = new Node(2);
            temp.next= New;
            temp = temp.next;
            
        }
        temp.next = null;
        return dummy.next;
        // add your code here
    }
}


//{ Driver Code Starts.

class GFG {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().segregate(head);
            printList(head);
        }
    }
}
// } Driver Code Ends