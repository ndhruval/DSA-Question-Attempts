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
    private class Temp {
        TreeNode node;
        int index;

        Temp(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        Queue<Temp> q = new LinkedList<>();
        q.offer(new Temp(root, 0));
        int maxWidth = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int minIndex = q.peek().index; // to normalize indices
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                Temp t = q.poll();
                TreeNode node = t.node;
                int index = t.index - minIndex; // normalize to prevent overflow

                if (i == 0) first = index;
                if (i == size - 1) last = index;

                if (node.left != null)
                    q.offer(new Temp(node.left, 2 * index));
                if (node.right != null)
                    q.offer(new Temp(node.right, 2 * index + 1));
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }
}
