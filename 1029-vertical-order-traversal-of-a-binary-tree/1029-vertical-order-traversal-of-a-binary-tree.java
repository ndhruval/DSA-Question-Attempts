/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private class NodeInfo{
        int row;
        int col;
        TreeNode node;

        NodeInfo(int r, int c, TreeNode node){
            this.row = r;
            this.col = c;
            this.node = node;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
        return ans;
        Queue<NodeInfo> q = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        q.offer(new NodeInfo(0,0,root));
        while(!q.isEmpty()){
            NodeInfo packet = q.poll();
            TreeNode Node = packet.node;
            int r = packet.row;
            int c = packet.col;

            map.computeIfAbsent(c,k -> new TreeMap<>())
            .computeIfAbsent(r,k-> new PriorityQueue<>())
            .offer(Node.val);

            if (Node.left != null) {
                q.offer(new NodeInfo( r + 1, c - 1,Node.left));
            }

            if (Node.right != null) {
                q.offer(new NodeInfo( r + 1, c + 1,Node.right));
            }
        }
        for(TreeMap<Integer,PriorityQueue<Integer>> column : map.values())
        {
            List<Integer> list = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : column.values()) {
                while (!nodes.isEmpty()) {
                    list.add(nodes.poll());
                }
            }
            ans.add(list);

        }
        return ans;



        
        
    }
}