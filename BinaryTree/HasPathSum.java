import utils.TreeNode;

public class HasPathSum {
      public static void main(String[] args) {
            TreeNode root = new TreeNode(5);
            root.left = new TreeNode(4);
            root.right = new TreeNode(8);
            root.left.left = new TreeNode(11);
            root.left.left.left = new TreeNode(7);
            root.left.left.right = new TreeNode(2);
            root.right.left = new TreeNode(13);
            root.right.right = new TreeNode(4);
            root.right.right.right = new TreeNode(1);
            System.out.println(hasPathSum(root, 22));
      }

      public static boolean hasPathSum(TreeNode root, int k) {
            if (root == null) {
                  return false;
            }
            k -= root.val;
            if (k == 0 && root.left == null && root.right == null) {
                  return true;
            }
            return hasPathSum(root.left, k) || hasPathSum(root.right, k);
      }
}
