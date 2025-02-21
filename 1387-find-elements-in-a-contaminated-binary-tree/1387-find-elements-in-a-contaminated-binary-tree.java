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
class FindElements {
    HashSet<Integer> set;

    public FindElements(TreeNode root) {
        set = new HashSet<>();
        bfs(root);
        
    }
    
    public boolean find(int target) {
        return set.contains(target);
        
    }
    private void bfs(TreeNode current)
    {
        Queue<TreeNode> q = new LinkedList<>();
        current.val=0;
        q.add(current);

        while(!q.isEmpty())
        {
            TreeNode currentNode = q.poll();
            set.add(currentNode.val);
            if(currentNode.left !=null)
            {
                currentNode.left.val = currentNode.val*2+1;
                q.add(currentNode.left);
            }
            if(currentNode.right != null)
            {
                currentNode.right.val = currentNode.val*2+2;
                q.add(currentNode.right);
            }
        }
        

    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */