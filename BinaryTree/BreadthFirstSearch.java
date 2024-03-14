import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
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

      public static void bfs(TreeNode node) {
            if (node == null) {
                  System.out.println(node);
            }

            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(node);

            while (!queue.isEmpty()) {
                  TreeNode currentNode = queue.poll();

                  System.out.print(currentNode.val + " ");

                  if (currentNode.left != null) {
                        queue.add(currentNode.left);
                  }
                  if (currentNode.right != null) {
                        queue.add(currentNode.right);
                  }
            }
      }

      public static void main(String[] args) {
            BreadthFirstSearch bfs = new BreadthFirstSearch();
            TreeNode root = bfs.new TreeNode(1);
            root.left = bfs.new TreeNode(2);
            root.right = bfs.new TreeNode(3);
            root.left.left = bfs.new TreeNode(4);
            root.left.right = bfs.new TreeNode(5);
            root.left.left.left = bfs.new TreeNode(6);
            root.left.left.right = bfs.new TreeNode(7);
            // specify the starting node, in this case, the root node
            BreadthFirstSearch.bfs(root);
      }
}
