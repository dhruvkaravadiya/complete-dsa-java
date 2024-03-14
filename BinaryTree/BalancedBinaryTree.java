// A tree whose leftHeight and rightHeight differ by at most 1 
// and its left and right sub tree are also balanced

public class BalancedBinaryTree {
      class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                  this.val = val;
            }

            TreeNode(int val, TreeNode left, TreeNode right) {
                  this.val = val;
                  this.left = left;
                  this.right = right;
            }
      }

      public static boolean isBalanced(TreeNode root) {
            if (root == null) {
                  return true;
            }

            int leftHeight = getSubTreeHeight(root.left);
            int rightHeight = getSubTreeHeight(root.right);

            boolean leftBalanced = isBalanced(root.left);
            boolean rightBalanced = isBalanced(root.right);

            boolean ans = ((Math.abs(leftHeight - rightHeight) <= 1) && leftBalanced && rightBalanced);
            return ans;
      }

      public static int getSubTreeHeight(TreeNode root) {
            if (root == null) {
                  return 0;
            }
            return 1 + Math.max(getSubTreeHeight(root.left), getSubTreeHeight(root.right));

      }

      public static void main(String[] args) {
            BalancedBinaryTree obj = new BalancedBinaryTree();
            TreeNode root = obj.new TreeNode(1);
            root.left = obj.new TreeNode(2);
            root.right = obj.new TreeNode(2);
            root.left.left = obj.new TreeNode(3);
            root.left.right = obj.new TreeNode(3);
            root.right.left = obj.new TreeNode(4);
            root.right.right = obj.new TreeNode(4);
            root.left.right.right = obj.new TreeNode(4);
            System.out.println(isBalanced(root));
      }
}
