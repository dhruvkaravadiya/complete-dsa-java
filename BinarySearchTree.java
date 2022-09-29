import java.util.*;
class BST {
    Node root;

    public class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // //Insert
    // insert - 60
    //    50
    //   / \
    // 20  70

    void insert(int newData) {
        Node newNode = new Node(newData);
        if (root == null) {
            root = newNode;
        } else {
            Node temp = root;
            while (temp.right != null || temp.left != null) {
                if (newNode.data >= temp.data && temp.right != null) {
                    temp = temp.right;
                } else {
                    temp = temp.left;
                }
            }
            if (newNode.data >= temp.data) {
                temp.right = newNode;
            } else {
                temp.left = newNode;
            }
        }
    }

    //Delete Node

    void deleteNode(int delElement) {
        Node parent = null;
        Node temp = root;

        while (temp.right != null && temp.left != null) {
            parent = temp;
            if (temp.data < delElement) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }

        // Case - 1 [ Delete Leaf Node ] 60
        /*
         *    50
         *   / \
         * 30  70
         *     /
         *   60
         */
        if (temp.right == null && temp.left == null) {
            if (parent.data > temp.data) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

        // Case - 2 [ Delete Node with 1 child ]
        if (temp.right == null || temp.left != null) {
            if (temp.data > parent.data) {
                parent.right = temp.left;
            } else {
                parent.left = temp.left;
            }
        }
        if (temp.right != null || temp.left == null) {
            if (temp.data > parent.data) {
                parent.right = temp.right;
            } else {
                parent.left = temp.left;
            }
        }
    }

    //INORDER

    void inOrder(){
        if(root == null){
            System.out.println("Root null");
        }
        else{
            Node temp = root;
            Stack<Node> stack = new Stack<>();
            while(stack.size()>0 && temp != null){
                while(temp != null){
                    stack.push(temp);
                    temp = temp.left;
                }
                temp = stack.pop();
                System.out.println(temp.data + " ");
                temp = temp.right;
            }
        }
    }

    //PREORDER

    void preOrder(){
        if(root == null){
            System.out.println("Root Null");
        }
        else{
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while(stack.size()>0){
                Node temp = stack.pop();
                System.out.println(temp.data+" ");
                if(temp.right!=null){
                    stack.push(temp.right);
                }
                if(temp.left!=null){
                    stack.push(temp.left);
                }
            }
        }
    }
}