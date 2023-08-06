package BinaryTree;
class Node {
        int value;
        Node left;
        Node right;
    
        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }
class BinaryTreeUsingLinkedList{
    Node root;
    
    public void traverseTree(Node node) {
        if (node != null) {
            traverseTree(node.left);
            System.out.print(" " + node.value);
            traverseTree(node.right);
        }
    }
    public void  insertPreOrder(int[] preorder){
        for(int key : preorder){
            root = insertRec(root,key);
        }
    }
    public Node insertRec(Node root , int key){
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.value) {
            root.left = insertRec(root.left, key);
        } else if (key > root.value) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }
}
public class BinaryTree {
   
    public static void main(String[] args) {
        BinaryTreeUsingLinkedList btree = new BinaryTreeUsingLinkedList();
        btree.root = new Node(2);
        btree.root.left = new Node(1);
        btree.root.right = new Node(3);
        //Traverse Before Insertion
        System.out.println("Before Adding Insertion");
        btree.traverseTree(btree.root);
        int[] preOrderTraversal = { 4, 5, 6, 7 };
        btree.insertPreOrder(preOrderTraversal);
        System.out.println("\nAfter Adding Insertion by PreOrder");
        btree.traverseTree(btree.root);
    }
}
