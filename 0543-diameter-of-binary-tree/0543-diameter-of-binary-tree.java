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
    public int diameterOfBinaryTree(TreeNode root) {
        int diameter[] = new int[1];

        Height(root,diameter);
        return diameter[0];
        
    }
    public int Height(TreeNode root, int[] diameter){
        if(root == null)
        return 0;

        int lh[] = new int[1];
        int rh[] = new int[1];

        lh[0] = Height(root.left,diameter);
        rh[0] = Height(root.right,diameter);

        diameter[0] = Math.max(diameter[0], lh[0]+rh[0]);

        return 1+ Math.max(lh[0],rh[0]);
    }
}