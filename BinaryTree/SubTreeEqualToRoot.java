public class SubTreeEqualToRoot {
      class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                  val = x;
            }
      }

      public static void main(String[] args) {
            SubTreeEqualToRoot obj = new SubTreeEqualToRoot();
            TreeNode root = obj.new TreeNode(3);
            root.left = obj.new TreeNode(4);
            root.right = obj.new TreeNode(5);
            root.left.left = obj.new TreeNode(1);
            root.left.right = obj.new TreeNode(2);
            TreeNode subRoot = obj.new TreeNode(4);
            subRoot.left = obj.new TreeNode(1);
            subRoot.right = obj.new TreeNode(2);
            System.out.println(obj.isSubTree(root, subRoot));
      }

      public boolean isSubTree(TreeNode root, TreeNode subRoot) {
            if (root == null) {
                  return false;
            }
            if (isEqual(root, subRoot)) {
                  return true;
            } else {
                  return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
            }
      }

      public boolean isEqual(TreeNode q, TreeNode p) {
            if (q == null && p == null) {
                  return true;
            }
            if (q == null || p == null) {
                  return false;
            }
            if (q.val != p.val) {
                  return false;
            }
            return isEqual(q.left, p.left) && isEqual(q.right, p.right);
      }

}
