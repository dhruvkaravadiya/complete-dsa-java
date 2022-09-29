import java.util.*;
class BinarySearchTree {
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
            while(stack.size()>0 || temp != null){
                while(temp != null){
                    stack.push(temp);
                    temp = temp.left;
                }
                temp = stack.pop();
                System.out.print(temp.data + " ");
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
                System.out.print(temp.data+" ");
                if(temp.right!=null){
                    stack.push(temp.right);
                }
                if(temp.left!=null){
                    stack.push(temp.left);
                }
            }
        }
    }


    //POSTORDER

    void postOrder(){
        if(root == null){
            System.out.println("Root Null");
        }
        else{
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(root);
            while(stack1.size()>0){
                Node temp = stack1.pop();
                stack2.push(temp);
                if(temp.right!=null){
                    stack1.push(temp.right);
                }
                if(temp.left!=null){
                    stack1.push(temp.left);
                }
            }
            while(stack2.size()>0){
                Node temp = stack2.pop();
                System.out.print(temp.data+" ");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree b1 = new BinarySearchTree();
        b1.insert(8);
        b1.insert(3);
        b1.insert(11);
        b1.insert(5);
        b1.insert(9);
        b1.insert(12);
        b1.insert(13);
        b1.insert(20);

//        System.out.println("Leaf Node Delete ");
//        b1.deleteLeafNode(20);
//        System.out.println();
//
//        System.out.println("Delete One Child Parent");
//        b1.deleteOneChild(12);
//        System.out.println();
//
//        System.out.println("Delete Two Chile Parent");
//        b1.deleteTwoChild(8);
//        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Preorder Traversal");
        b1.preOrder();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        System.out.println("Inorder Traversal");
        b1.inOrder();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        System.out.println("Postorder Traversal");
        b1.postOrder();
        System.out.println();
    }
}



