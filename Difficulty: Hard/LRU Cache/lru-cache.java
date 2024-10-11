//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            int capacity = Integer.parseInt(read.readLine());
            int queries = Integer.parseInt(read.readLine());
            LRUCache cache = new LRUCache(capacity);
            String str[] = read.readLine().trim().split(" ");
            int len = str.length;
            int itr = 0;

            for (int i = 0; (i < queries) && (itr < len); i++) {
                String queryType = str[itr++];
                if (queryType.equals("SET")) {
                    int key = Integer.parseInt(str[itr++]);
                    int value = Integer.parseInt(str[itr++]);
                    cache.set(key, value);
                }
                if (queryType.equals("GET")) {
                    int key = Integer.parseInt(str[itr++]);
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way

class LRUCache {
    // Node class for doubly linked list
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }

    private int capacity;
    private HashMap<Integer, Node> cache = new HashMap<>();
    private Node head, tail;

    // Constructor for initializing the cache capacity with the given value.
    public LRUCache(int cap) {
        this.capacity = cap;

        // Initialize the dummy head and tail nodes
        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }

    // Function to return value corresponding to the key.
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1; // Key not found
        }
        // Move the accessed node to the head (mark as recently used)
        moveToHead(node);
        return node.value;
    }

    // Function for storing key-value pair.
    public void set(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            // Update the value
            node.value = value;
            // Move the node to the head (mark as recently used)
            moveToHead(node);
        } else {
            // Create a new node
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            // Add to the HashMap and the doubly linked list
            cache.put(key, newNode);
            addNode(newNode);

            // If capacity is exceeded, remove the LRU item
            if (cache.size() > capacity) {
                Node tailNode = popTail();
                cache.remove(tailNode.key);
            }
        }
    }

    // Adds a new node right after the head
    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    // Removes an existing node from the linked list
    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    // Moves a node to the head (mark as recently used)
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    // Pops the least recently used node (from the tail)
    private Node popTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }
}