
import utils.TreeNode;

public class PreOrderTraversal {
    public static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public static void main(String[] args) {
        TreeNode btree = new TreeNode(1);
        btree.left = new TreeNode(2);
        btree.right = new TreeNode(3);
        btree.left.left = new TreeNode(4);
        btree.left.right = new TreeNode(5);
        btree.right.left = new TreeNode(6);
        btree.right.right = new TreeNode(7);
        System.out.println("Pre-Order Traversal");
        preOrderTraversal(btree);
    }
}
