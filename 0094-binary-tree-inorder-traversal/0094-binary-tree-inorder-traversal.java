class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            // Reach the leftmost node
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Current must be null at this point
            current = stack.pop();
            result.add(current.val);  // Visit node
            current = current.right;  // Visit right subtree
        }

        return result;
    }
}
