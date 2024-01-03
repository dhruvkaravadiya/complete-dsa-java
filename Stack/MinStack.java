class MinStackImplementation{

      Node min;
      Node top;

      class Node {
            int data;
            Node next;

            Node(int data) {
                  this.data = data;
                  this.next = null;
            }
      }

      public MinStackImplementation() {
            this.top = null;
            this.min = null;
      }

      public void push(int value) {
            Node temp = new Node(value);
            if (top == null) {
                  top = temp;
                  min = temp;
            } else {
                  temp.next = top;
                  top = temp;
                  if (temp.data < min.data) {
                        min = temp;
                  }
            }
      }

      public void pop() {
            // is min is on the top, then find the new min
            if (top == min) {
                  // first store the address of the top
                  Node newTop = top.next;
                  // now assig the null to top
                  top.next = null;
                  top = newTop;

                  // now update the min by findng the new min
                  Node current = top;
                  // start from top so assume top to be min
                  min = top;
                  // now find the min by iterating over whole of the stack
                  while (current != null) {
                        if (current.data <= min.data) {
                              min = current;
                        }
                        current = current.next;
                  }

            }
            // when the top is not min
            top = top.next;
      }

      public int top() {
            return top.data;
      }

      public int getMin() {
            return min.data;
      }

}


public class MinStack{
      public static void main(String[] args) {
             MinStackImplementation obj = new MinStackImplementation();
      obj.push(3);
            obj.push(5);
                  obj.push(1);
                        obj.push(2);
                              obj.push(8);
      obj.pop();
      int param_3 = obj.top();

      int param_4 = obj.getMin();
            System.out.println(param_3);

                  System.out.println(param_4);

      }
     
}