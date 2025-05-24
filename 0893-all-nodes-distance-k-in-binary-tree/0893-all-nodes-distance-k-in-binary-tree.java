class Solution {
    public void markParents(TreeNode root, HashMap<TreeNode, TreeNode> parents) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                parents.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                parents.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        markParents(root, parents);

        HashMap<TreeNode, Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        vis.put(target, true);

        int currDist = 0;
        while (!q.isEmpty()) {
            if (currDist == k) break;
            int size = q.size();
            currDist++;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null && !vis.containsKey(node.left)) {
                    vis.put(node.left, true);
                    q.add(node.left);
                }
                if (node.right != null && !vis.containsKey(node.right)) {
                    vis.put(node.right, true);
                    q.add(node.right);
                }
                if (parents.containsKey(node) && !vis.containsKey(parents.get(node))) {
                    vis.put(parents.get(node), true);
                    q.add(parents.get(node));
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
    }
}