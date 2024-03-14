public class ValidateBinaryTree {
      class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                  val = x;
            }
      }

      static TreeNode previous = null;

      public static boolean isValidBST(TreeNode root) {
            if (root == null) {
                  return true;
            }
            if (!isValidBST(root.left)) {
                  return false;
            }
            if (previous != null && previous.val >= root.val) {
                  return false;
            }
            previous = root;
            if (!isValidBST(root.right)) {
                  return false;
            }
            return true;
      }

      public static void main(String[] args) {
            ValidateBinaryTree obj = new ValidateBinaryTree();
            TreeNode root = obj.new TreeNode(2);
            root.left = obj.new TreeNode(1);
            root.right = obj.new TreeNode(3);
            System.out.println(ValidateBinaryTree.isValidBST(root));
      }
}
