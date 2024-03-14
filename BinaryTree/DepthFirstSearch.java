
public class DepthFirstSearch {
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

      public void dfs(TreeNode node, int k) {
            if (node == null) {
                  return;
            }
            if (k == node.val) {
                  System.out.println(true);
                  System.out.print(node.val + " ");
                  return;
            }
            // Recursively traverse the left subtree
            dfs(node.left, k);

            // Recursively traverse the right subtree
            dfs(node.right, k);
      }

      public static void main(String[] args) {
            // Create an instance of the DepthFirstSearch class
            DepthFirstSearch dfs = new DepthFirstSearch();

            // Create a sample binary tree
            TreeNode root = dfs.new TreeNode(1);
            root.left = dfs.new TreeNode(2);
            root.right = dfs.new TreeNode(3);
            root.left.left = dfs.new TreeNode(4);
            root.left.right = dfs.new TreeNode(5);
            root.right.left = dfs.new TreeNode(6);
            root.right.right = dfs.new TreeNode(7);
            // Perform depth-first search on the binary tree
            dfs.dfs(root, 5);
      }
}