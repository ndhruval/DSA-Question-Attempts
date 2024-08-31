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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null)
        return result;

        boolean lefttoright = true;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        while(!q.isEmpty())
        {
            int size = q.size();

            List<Integer> row = new ArrayList<Integer>(size);

            for(int i = 0;i<size;i++)
            {
                TreeNode curr = q.poll();

                if (lefttoright) {
                    row.add(curr.val);
                } else {
                    row.add(0, curr.val);  // Adding to the front for reverse order
                }

                if(curr.left != null)
                q.offer(curr.left);
                if(curr.right != null)
                q.offer(curr.right);

            }
            lefttoright = !lefttoright;

            result.add(row);
        }
        return result;

        
        
    }
}