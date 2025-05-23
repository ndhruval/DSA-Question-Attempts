/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    
    private static class Temp{
        Node node;
        int vertical;
        
        Temp(Node node, int vertical)
        {
            this.node  = node;
            this.vertical = vertical;
        }
    }
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        
        ArrayList<Integer> answer = new ArrayList<>();
        if(root == null)
        return answer;
                
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Temp> q = new LinkedList<>();
        q.offer(new Temp(root,0));
        while(!q.isEmpty())
        {
            Temp t = q.poll();
            Node n = t.node;
            int v = t.vertical;
            
            if(!map.containsKey(v))
            map.put(v, n.data); 
            
            if (n.left != null) {
                q.offer(new Temp(n.left, v - 1));
            }
            if (n.right != null) {
                q.offer(new Temp(n.right, v + 1));
            }

        }
        
        for(int values: map.values())
        {
            answer.add(values);
        }
        return answer;
        // code here
        
    }
}