package BinaryTree;
class Node {
        int data;
        Node left;
        Node right;
    
        Node(int value) {
            this.data = value;
            right = null;
            left = null;
        }
    }
class BinaryTreeUsingLinkedList{
    Node root;
    BinaryTreeUsingLinkedList(){
        root = null;
    }
    void insert(int data){
        //recursively call the insert method
        root = insertNodeRecursively(root, data);
    }
    public Node insertNodeRecursively(Node root , int key){
        //assume tree is empty
        if(root == null){
            root = new Node(key);
            return root;
        }
        //traverse the tree to far most left or right
        // if the value is less than the root node
        if(key < root.data){
            root.left = insertNodeRecursively(root.left, key);
        }
        // if the value is more than the root node
        else if(key > root.data){
            root.right = insertNodeRecursively(root.right , key);
        }
        return root;
    }
    void inorderTraversal(Node node){
        if (node == null)
            return;
        if(root!=null){
            inorderTraversal(node.left);
            System.out.print(" "+node.data+" ");
            inorderTraversal(node.right);
        }
    }
    void preorderTraversal(Node node){
        if (node == null)
            return;
        if(root!=null){
            System.out.print(" "+node.data+" ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }
    void postorderTraversal(Node node){
        if (node == null)
            return;
        if(node!=null){
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(" "+node.data+" ");
        }
    }
}
public class BinaryTree {
    
    public static void main(String[] args) {
        BinaryTreeUsingLinkedList btree = new BinaryTreeUsingLinkedList();
        btree.insert(1);
        btree.insert(2);
        btree.insert(3);
        btree.insert(4);
        btree.insert(5);
        btree.insert(6);
        btree.insert(7);
        btree.insert(8);
        btree.insert(9);
        btree.insert(10);
        System.out.print("Inorder Traversal : \n");
        btree.inorderTraversal(btree.root);
        System.out.print("\nPre Order Traversal : \n");
        btree.preorderTraversal(btree.root);    
        System.out.print("\nPost Order Traversal : \n");
        btree.postorderTraversal(btree.root);
    }
}