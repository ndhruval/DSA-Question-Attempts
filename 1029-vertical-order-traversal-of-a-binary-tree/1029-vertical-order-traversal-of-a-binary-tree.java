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
import java.util.*;

class Solution {

    // Custom class to store a tree node along with its column and level index
    private static class NodeInfo {
        TreeNode node;
        int col;
        int row;

        NodeInfo(TreeNode node, int col, int row) {
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        // TreeMap to store nodes sorted by column and then by level and value
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        // Queue for BFS
        Queue<NodeInfo> queue = new ArrayDeque<>();
        queue.offer(new NodeInfo(root, 0, 0));

        // Perform BFS
        while (!queue.isEmpty()) {
            NodeInfo removed = queue.poll();
            TreeNode node = removed.node;
            int col = removed.col;
            int row = removed.row;

            // Add node to the map at the correct column and row, sorted by value
            map.computeIfAbsent(col, k -> new TreeMap<>())
                .computeIfAbsent(row, k -> new PriorityQueue<>())
                .offer(node.val);

            // Add left and right children to the queue with updated column and row indices
            if (node.left != null) {
                queue.offer(new NodeInfo(node.left, col - 1, row + 1));
            }
            if (node.right != null) {
                queue.offer(new NodeInfo(node.right, col + 1, row + 1));
            }
        }

        // Compile the result list from the map, ordered by column, then by row, then by value
        for (TreeMap<Integer, PriorityQueue<Integer>> column : map.values()) {
            List<Integer> columnList = new ArrayList<>();
            for (PriorityQueue<Integer> nodes : column.values()) {
                while (!nodes.isEmpty()) {
                    columnList.add(nodes.poll());
                }
            }
            ans.add(columnList);
        }

        return ans;
    }
}
