//The minimum depth is the number of nodes along the shortest path
// from the root node down to the nearest leaf node.
package Depths;
import utils.TreeNode;

public class MinDepthOfBST {
    public static int BSTMinHeight(TreeNode node) {
        //if no node in tree
        if(node == null){
            return 0;
        }
        //if leaf node
        if(node.left == null && node.right == null){
            return 1;
        }
        if(node.left!=null && node.right == null){
            return BSTMinHeight(node.left) + 1;
        }
        if(node.left==null && node.right != null){
            return BSTMinHeight(node.right) + 1;
        }
        return Math.min(BSTMinHeight(node.right) , BSTMinHeight(node.left)) + 1;
    } 
    public static void main(String[] args) {
        TreeNode btree = new TreeNode(1);
        btree.left = new TreeNode(4);
        btree.right = new TreeNode(6);
        btree.left.left = new TreeNode(7);
        System.out.println(BSTMinHeight(btree));
    }  
}
