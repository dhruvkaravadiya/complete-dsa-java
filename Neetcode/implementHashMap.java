class Node {
    int key;
    int value;
    Node next;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class CustomHashMap {

    Node[] HashMap;

    CustomHashMap() {
        HashMap = new Node[1000000];
    }

    public void put(int key, int value) {

        int index = key % 1000000;

        if (HashMap[index] == null) {
            Node newNode = new Node(key, value);
            HashMap[index] = newNode;
            return;
        }

        Node current = HashMap[index];

        while (current != null) {

            if (current.key == key) {
                current.value = value;
                return;
            }

            if (current.next == null) {
                current.next = new Node(key, value);
                return;
            }

            current = current.next;
        }
    }

    public int get(int key) {

        int index = key % 1000000;

        Node current = HashMap[index];

        while (current != null) {

            if (current.key == key) {
                return current.value;
            }

            current = current.next;
        }

        return -1;
    }

    public void remove(int key) {

        int index = key % 1000000;

        Node current = HashMap[index];

        if (current == null) {
            return;
        }

        if (current.key == key) {
            HashMap[index] = current.next;
            return;
        }

        while (current.next != null) {

            if (current.next.key == key) {
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }
    }
}

public class ImplementHashMap {

    public static void main(String[] args) {

        CustomHashMap map = new CustomHashMap();

        // Normal insertion
        map.put(1, 100);
        map.put(2, 200);
        map.put(3, 300);

        System.out.println(map.get(1));  // 100
        System.out.println(map.get(2));  // 200
        System.out.println(map.get(3));  // 300

        // Updating existing key
        map.put(1, 500);

        System.out.println(map.get(1));  // 500

        // Collision testing
        map.put(5, 1000);
        map.put(1000005, 2000);
        map.put(2000005, 3000);

        System.out.println(map.get(5));        // 1000
        System.out.println(map.get(1000005));  // 2000
        System.out.println(map.get(2000005));  // 3000

        // Remove middle node from collision chain
        map.remove(1000005);

        System.out.println(map.get(5));        // 1000
        System.out.println(map.get(1000005));  // -1
        System.out.println(map.get(2000005));  // 3000

        // Remove first node from collision chain
        map.remove(5);

        System.out.println(map.get(5));        // -1
        System.out.println(map.get(2000005));  // 3000

        // Key doesn't exist
        System.out.println(map.get(999));      // -1
    }
}