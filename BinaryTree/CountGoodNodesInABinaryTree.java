import utils.TreeNode;

public class CountGoodNodesInABinaryTree {
      public static void main(String[] args) {
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(1);
            root.right = new TreeNode(4);
            root.left.left = new TreeNode(3);
            root.right.left = new TreeNode(1);
            root.right.right = new TreeNode(5);
            System.out.println(goodNodes(root));

      }

      public static int goodNodes(TreeNode root) {
            dfs(root, Integer.MIN_VALUE);
            return count;
      }

      public static int count = 0;

      public static void dfs(TreeNode root, int k) {
            if (root == null) {
                  return;
            }
            if (root.val >= k) {
                  count++;
                  dfs(root.left, root.val);
                  dfs(root.right, root.val);
            } else {
                  dfs(root.left, k);
                  dfs(root.right, k);
            }

      }
}
