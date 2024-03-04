//The minimum depth is the number of nodes along the shortest path
// from the node node down to the nearest leaf node.

import utils.TreeNode;

public class MinDepthOfBST {
	public static int BSTMinHeight(TreeNode node) {
		// if node null
		if (node == null) {
			return 0;
		}
		// if leaf node
		if (node.left == null && node.right == null) {
			return 1;
		}
		// if right subtree not null and left subtree is null
		if (node.left == null) {
			return BSTMinHeight(node.right) + 1;
		}
		// if left subtree not null and right subtree is null
		if (node.right == null) {
			return BSTMinHeight(node.left) + 1;
		}
		// if left and right subtree both not null
		return Math.min(BSTMinHeight(node.left), BSTMinHeight(node.right)) + 1;
	}

	public static void main(String[] args) {
		TreeNode btree = new TreeNode(1);
		btree.left = new TreeNode(4);
		btree.right = new TreeNode(6);
		btree.left.left = new TreeNode(7);
		System.out.println(BSTMinHeight(btree));
	}
}
