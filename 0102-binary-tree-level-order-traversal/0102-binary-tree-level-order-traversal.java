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
class Solution 
{
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)
        return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            int level = q.size();
            List<Integer> currlev = new ArrayList<>();
            for(int i=0;i<level;i++)
            {
                TreeNode currentnode = q.poll();
                currlev.add(currentnode.val);
                if(currentnode.left!=null)
                q.offer(currentnode.left);
                if(currentnode.right!=null)
                q.offer(currentnode.right);
            }
            list.add(currlev);
        }
        return list;

        
    }
}