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
    public TreeNode insertIntoBST(TreeNode root, int key) 
    {
        if(root == null)
        {
            root= new TreeNode(key);
            return root;
        }
        else if (key < root.val)
			root.left = insertIntoBST(root.left, key);
		else if (key > root.val)
			root.right = insertIntoBST(root.right, key);

		
		return root;


        
    }
}