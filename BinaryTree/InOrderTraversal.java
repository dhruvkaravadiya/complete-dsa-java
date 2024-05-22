
import utils.TreeNode;

public class InOrderTraversal {
    public static void inorderTraversal(TreeNode node) {
        if (node == null)
            return;
        else {
            inorderTraversal(node.left);
            System.out.print(node.val + " ");
            inorderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode btree = new TreeNode(1);
        btree.left = new TreeNode(2);
        btree.right = new TreeNode(3);
        btree.left.left = new TreeNode(4);
        btree.left.right = new TreeNode(5);
        btree.right.left = new TreeNode(6);
        btree.right.right = new TreeNode(7);
        System.out.println("In-Order Traversal");
        inorderTraversal(btree);
    }
}
