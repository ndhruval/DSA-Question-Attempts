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
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        int count[] = new int[1];
        count[0] = 0;
        counter(root, max, count);
        return count[0];
        
    }
    public void counter(TreeNode root, int max, int[] count){
        if(root == null)
        return;
        if(root.val >= max){
            count[0]++;
            max = root.val;
        }
        counter(root.left, max, count);
        counter(root.right, max, count);

    }
}