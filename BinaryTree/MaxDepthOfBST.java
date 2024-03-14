// Max Depth / Height of BST : 
// Number of nodes along the longest path
// from the root node down to the farthest leaf node.

import utils.TreeNode;

public class MaxDepthOfBST {
    public static int BSTMaxHeight(TreeNode node) {
        // if (node == null) {
        // return 0;
        // } else {
        // int leftTreeHeight = BSTMaxHeight(node.left);
        // int rightTreeHeight = BSTMaxHeight(node.right);
        // if (leftTreeHeight < rightTreeHeight) {
        // return rightTreeHeight + 1;
        // } else {
        // return leftTreeHeight + 1;
        // }
        // }
        return node == null ? 0 : 1 + Math.max(BSTMaxHeight(node.left), BSTMaxHeight(node.right));
    }

    public static void main(String[] args) {
        TreeNode btree = new TreeNode(1);
        btree.left = new TreeNode(4);
        btree.right = new TreeNode(6);
        btree.left.left = new TreeNode(7);
        System.out.println(BSTMaxHeight(btree));
    }
}