package LinkedList;

import java.util.HashSet;
import utils.Node;

public class insertionOfTwoLists {

}

class Solution {
      public Node getIntersectionNode(Node headA, Node headB) {
            HashSet<Node> set = new HashSet<>();

            while (headA != null) {
                  set.add(headA);
                  headA = headA.next;
            }
            while (headB != null) {
                  if (set.contains(headB)) {
                        return headB;
                  }
                  headB = headB.next;
            }
            return null;
      }
}