
public class InvertBinaryTree {
      public class TreeNode {
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

      public static TreeNode invertTree(TreeNode root) {
            if (root == null) {
                  return null;
            }

            // Swap the left and right subtrees
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            // Recursively invert the left and right subtrees
            invertTree(root.left);
            invertTree(root.right);

            return root;
      }

      public static void main(String[] args) {
            // Create a sample binary tree
            InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
            InvertBinaryTree.TreeNode root = invertBinaryTree.new TreeNode(4);
            root.left = invertBinaryTree.new TreeNode(2);
            root.right = invertBinaryTree.new TreeNode(7);
            root.left.left = invertBinaryTree.new TreeNode(1);
            root.left.right = invertBinaryTree.new TreeNode(3);
            root.right.left = invertBinaryTree.new TreeNode(6);
            root.right.right = invertBinaryTree.new TreeNode(9);
            InvertBinaryTree.printTree(root);
            System.out.println();
            // Invert the binary tree
            InvertBinaryTree.TreeNode invertedTree = InvertBinaryTree.invertTree(root);

            // Print the inverted tree
            InvertBinaryTree.printTree(invertedTree);
      }

      public static void printTree(TreeNode root) {
            if (root == null) {
                  return;
            }

            // Print the current node
            System.out.print(root.val + " ");

            // Print the left subtree
            printTree(root.left);

            // Print the right subtree
            printTree(root.right);
      }
}
