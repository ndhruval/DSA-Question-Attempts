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
    public int maxPathSum(TreeNode root) 
    {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        max_Sum(root, max);
        return max[0];

        
        
    }
    public int max_Sum(TreeNode root, int[] max)
    {
        if(root == null)
        return 0;

        int leftmax = Math.max(0,max_Sum(root.left,max));
        int rightmax = Math.max(0,max_Sum(root.right,max));

        max[0] = Math.max(max[0], leftmax + rightmax + root.val);

        return Math.max(leftmax, rightmax) + root.val;
    }
}