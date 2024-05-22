import utils.TreeNode;

public class SumRootToLeafNumbers {
      public static void main(String[] args) {
            TreeNode root = new TreeNode(4);
            root.left = new TreeNode(1);

            root.right = new TreeNode(3);
            System.err.println(sumNumbers(root));
      }

      public static int sumNumbers(TreeNode root) {
            return sumNumbersHelper(root, 0);
      }

      private static int sumNumbersHelper(TreeNode node, int currentSum) {
            if (node == null) {
                  return 0;
            }

            currentSum = currentSum * 10 + node.val;

            // If it's a leaf node, return the current sum
            if (node.left == null && node.right == null) {
                  return currentSum;
            }

            // Otherwise, recurse left and right
            int leftSum = sumNumbersHelper(node.left, currentSum);
            int rightSum = sumNumbersHelper(node.right, currentSum);

            return leftSum + rightSum;
      }
}
