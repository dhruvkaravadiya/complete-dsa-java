// first create a node class
class Node{
    Node next;
    int key;

    Node(int key){
        this.key = key;
        this.next = null;
    }
}

// a typical hashset contains 0-9 numbering buckets when we will do modulo
class CustomHashSet{ 
    Node[] HashSet;

    CustomHashSet(){
        HashSet = new Node[10];
    }

    public void add(int key){
        int temp = key%10;
        Node newNode = new Node(key);
        // first check if the particular space 
        // for the key is empty or not in HashSet
        if(HashSet[temp] == null){
            HashSet[temp] = newNode;
            return;
        }
        // bucket may contain the current key so check it

        Node current = HashSet[temp];
        //if some node is already residing at the particular index,
        // then we need to check further if the particular key should not exist , if it is dont add it
          while(current !=null){
            if(current.key == key){
                return;
            }

            // we will add the newNode as soon as we reach the end
            if(current.next == null){
                current.next = newNode;
                return;
            }
            //move to next node
            current = current.next;
          }
    }
    public void remove(int key){
        int temp = key%10;
        Node current = HashSet[temp];
        Node prev = null;
        // now we will find the key in the linked list and remove it
        while(current!=null){
            //if we have reached the key to be removed
            if(current.key == key){
                //if we have the first element as the key to be removed , 
                // then we will just shift the head that is the HashSet[temp] to the next node
                if(prev == null){
                    HashSet[temp] = current.next;
                    return;
                }
                // if first element is not the key , then maybe middle or last if the key
                // then we just have to use the prev node to connect the node after the 
                // key that will be removed so the middle node if deleted
                else{
                    prev.next = current.next;
                    return;
                }
            }
            // if we have not found the key , simply shift the prev and current node.
            else{
                prev = current;
                current = current.next;
            }
        }
    }
    public boolean containsKey(int key){
        int temp = key%10;
        Node current = HashSet[temp];
        while(current!=null){
            if(current.key == key){
                return true;
            }
            else{
                current = current.next;
            }
        }
        return false;
    }
}
public class implementHashSet{
    public static void main(String[] args){
        
        CustomHashSet hashSet = new CustomHashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
        hashSet.add(5);
        hashSet.add(6);
        hashSet.add(7);
        hashSet.add(8);
        hashSet.add(9);
        hashSet.add(10);
        hashSet.remove(5);    
        System.out.println("HashSet implemented successfully");
        System.out.println("Contains key 5: " + hashSet.containsKey(5));
    }
}