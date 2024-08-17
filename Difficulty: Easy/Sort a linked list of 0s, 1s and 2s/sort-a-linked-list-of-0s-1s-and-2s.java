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
        Node Res = head;
        
        
        int cnt[] =  new int[3];
        
        Node temp = head;
        while(temp != null)
        {
            cnt[temp.data]++;
            temp = temp.next;
        }
        for(int i=0;i< cnt[0];i++)
        {
            head.data =0;
            head = head.next;
            
        }
        for(int i=0;i< cnt[1];i++)
        {
            head.data =1;
            head = head.next;
            
        }
        for(int i=0;i< cnt[2];i++)
        {
            head.data =2;
            head = head.next;
            
        }
        return Res;
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