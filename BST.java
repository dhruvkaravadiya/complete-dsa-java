class Implement{
    Node root;
    class Node{
        int data;
        Node left,right;
        Node(int a){
            data = a;
            left = null;
            right = null;
        }
    } 
     public void insert(int inpData){
        Node nnode = new Node(inpData);
        if(root == null){
            root = nnode;
        }
        else{
            Node temp = root;
            while(nnode.left!=null || nnode.right!=null){
                if(nnode.data>=temp.data && temp.right != null){
                    temp=temp.right;
                }
                else if(nnode.data<temp.data && temp.left!=null){
                    temp = temp.left;
                }
                else{
                    break;
                }
            }
            if(nnode.data>=temp.data){
                temp.right=nnode;
            }
            else{
                temp.left=nnode;
            }
        }
    }
    
}
public class main{
    public static void main(String[] args) {
        Implement I1=new Implement();
        I1.insert(1);
    }
}
