class Link{

	static Node head;
	static class Node{
		int value;
		Node next;
		Node(int n){
			value=n;
			next=null;
		}
	}
	static void insert(int m){
		Node mNode = new Node(m);
		if(head==null){
			head=mNode;
		}
		else{
			Node lastNode = head;
			while(lastNode.next!=null){
				lastNode=lastNode.next;
			}
			lastNode.next=mNode;
		}
	}

	static void display(){
		Link lastNode2=new Link();
		if(head==null){
			System.out.println("Empty");
		}
		else{
			System.out.print("\nLinked List :");
			Node lastNode = head;
			while(lastNode.next!=null){
				System.out.print(lastNode.value+" => ");
				lastNode=lastN
				\
				ode.next;
			}
			System.out.print(lastNode.value);
			
		}
	}
}

class LinkedListDemo{
	public static void main(String[] args) {
		Link obj = new Link();
		obj.insert(5);
		obj.insert(6);
		obj.insert(7);
		obj.insert(8);
		obj.insert(9);
		obj.insert(10);
		obj.display();
		obj.insert(20);
		obj.display();	
	}

}
