package utils;

public class BinaryTreeInsert {
    public TreeNode root;
    public BinaryTreeInsert(){
        root = null;
    }
    public void insert(int data){
        //recursively call the insert method
        root = insertNodeRecursively(root, data);
    }
    TreeNode insertNodeRecursively(TreeNode root , int key){
        //assume tree is empty
        if(root == null){
            root = new TreeNode(key);
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
}
