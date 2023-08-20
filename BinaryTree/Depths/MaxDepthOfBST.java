package Depths;
import utils.TreeNode;

public class MaxDepthOfBST {
    public static int BSTHeight(TreeNode node){
        if(node == null){
            return 0;
        }
        else{
            int leftTreeHeight = BSTHeight(node.left);
            int rightTreeHeight =  BSTHeight(node.right);

            if(leftTreeHeight < rightTreeHeight){
                return leftTreeHeight + 1;
            }
            else{
                return rightTreeHeight + 1;
            }
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
        System.out.println(BSTHeight(btree));
    }
}
