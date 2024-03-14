import java.util.ArrayList;
import java.util.List;

public class KthSmallestNode {
      class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                  val = x;
            }
      }

      public static void inOrderTraversal(TreeNode root, List<Integer> list) {
            if (root == null) {
                  return;
            }
            inOrderTraversal(root.left, list);
            list.add(root.val);
            inOrderTraversal(root.right, list);
      }

      public static int kthSmallestNode(TreeNode root, int k) {
            if (root == null) {
                  return -1;
            }
            List<Integer> list = new ArrayList<>();
            inOrderTraversal(root, list);
            return list.get(k - 1);
      }

      public static void main(String[] args) {
            KthSmallestNode obj = new KthSmallestNode();
            TreeNode root = obj.new TreeNode(3);
            root.left = obj.new TreeNode(1);
            root.right = obj.new TreeNode(4);
            root.left.right = obj.new TreeNode(2);
            System.out.println(kthSmallestNode(root, 3));
      }
}
