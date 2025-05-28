// User function Template for Java

class Solution {
    public static int floor(Node root, int key) {
        int floor = -1;
        while(root != null)
        {
            if(root.data == key)
            return root.data;
            
            if(key> root.data)
            {
                floor = root.data;
                root = root.right;
            }
            else
            root = root.left;
        }
        return floor;
        // Code here
        
    }
}