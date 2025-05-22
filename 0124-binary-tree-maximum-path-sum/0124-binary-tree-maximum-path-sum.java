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
    public int maxPathSum(TreeNode root) {
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE;
        max_sum(root,max);
        return max[0];
        
    }
    public int max_sum(TreeNode root, int[] max)
    {
        if(root == null)
        return 0;

        int left_max = Math.max(0, max_sum(root.left,max));
        int right_max = Math.max(0, max_sum(root.right,max));

        max[0] = Math.max(max[0], left_max + right_max + root.val);

        return Math.max(left_max,right_max) + root.val;

    }
}