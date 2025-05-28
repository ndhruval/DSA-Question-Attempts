public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("#,");
            } else {
                sb.append(node.val).append(",");
                q.offer(node.left);
                q.offer(node.right);
            }
        }

        // Remove the last comma
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < nodes.length) {
            TreeNode node = q.poll();

            // Left child
            if (!nodes[i].equals("#")) {
                node.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(node.left);
            }
            i++;

            // Right child
            if (i < nodes.length && !nodes[i].equals("#")) {
                node.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(node.right);
            }
            i++;
        }

        return root;
    }
}
