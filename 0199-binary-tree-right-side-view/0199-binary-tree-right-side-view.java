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
    public List<Integer> rightSideView(TreeNode root) 
    {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null)
        return list;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            int levelsize = q.size();
            for(int i= 0;i<levelsize ; i++)
            {
                TreeNode curr = q.poll();
                if(i==levelsize-1)
                list.add(curr.val);
                if(curr.left != null)
                q.offer(curr.left);
                if(curr.right != null)
                q.offer(curr.right);

            }
        }
        return list;

        
    }
}