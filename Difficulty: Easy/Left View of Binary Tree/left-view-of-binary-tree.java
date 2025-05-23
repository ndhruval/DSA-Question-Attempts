/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Solution {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null)
        return list;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            int levelsize = q.size();
            for(int i= 0;i<levelsize ; i++)
            {
                Node curr = q.poll();
                if(i==0)
                list.add(curr.data);
                if(curr.left != null)
                q.offer(curr.left);
                if(curr.right != null)
                q.offer(curr.right);

            }
        }
        return list;
        // code here
        
    }
}