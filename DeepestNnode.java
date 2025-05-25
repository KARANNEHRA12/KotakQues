public class DeepestNnode {

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    public class DeepestNodeFinder {

        // Get the height (depth) of the tree
        private int computeHeight(TreeNode root) {
            int height = 0;
            while (root.left != null) {
                height++;
                root = root.left;
            }
            return height;
        }

        // Check if node exists at index in last level
        private boolean exists(int idx, int depth, TreeNode node) {
            int left = 0, right = (int)Math.pow(2, depth) - 1;

            for (int i = 0; i < depth; i++) {
                int mid = (left + right) / 2;
                if (idx <= mid) {
                    node = node.left;
                    right = mid;
                } else {
                    node = node.right;
                    left = mid + 1;
                }
            }

            return node != null;
        }

        // Find the value of the deepest node
        public int findDeepestNode(TreeNode root) {
            if (root == null) return -1;

            int depth = computeHeight(root);

            int left = 0, right = (int)Math.pow(2, depth) - 1;
            int lastIndex = -1;
            TreeNode lastNode = null;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (exists(mid, depth, root)) {
                    lastIndex = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            // Traverse to the deepest node at lastIndex
            TreeNode curr = root;
            int l = 0, r = (int)Math.pow(2, depth) - 1;
            for (int i = 0; i < depth; i++) {
                int m = (l + r) / 2;
                if (lastIndex <= m) {
                    curr = curr.left;
                    r = m;
                } else {
                    curr = curr.right;
                    l = m + 1;
                }
            }

            return curr.val;
        }
    }

}
