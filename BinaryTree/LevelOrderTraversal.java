import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
      class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                  val = x;
            }
      }

      public static void main(String[] args) {
            LevelOrderTraversal obj = new LevelOrderTraversal();
            TreeNode root = obj.new TreeNode(3);
            root.left = obj.new TreeNode(4);
            root.right = obj.new TreeNode(5);
            root.left.left = obj.new TreeNode(1);
            root.left.right = obj.new TreeNode(2);
            List<List<Integer>> list = obj.levelOrder(root);
            display(list);
      }

      public static void display(List<List<Integer>> list) {
            for (List<Integer> levelNodes : list) {
                  for (int node : levelNodes) {
                        System.out.print(node + " ");
                  }
                  System.out.println();
            }
      }

      public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            if (root == null) {
                  return list;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                  int size = queue.size();
                  List<Integer> levelNodes = new ArrayList<>();
                  for (int i = 0; i < size; i++) {
                        TreeNode node = queue.poll();
                        if (node.left != null) {
                              queue.add(node.left);
                        }
                        if (node.right != null) {
                              queue.add(node.right);
                        }
                        levelNodes.add(node.val);
                  }
                  list.add(levelNodes);
            }
            return list;
      }
}
