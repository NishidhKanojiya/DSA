public class DLL {
    Node head;
    Node tail;
    int size;

    DLL() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;// connect the new node next to the head
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void insertLast(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
            size++;
        }

    }

    public void insertAtIndex(int val, int index) {
        if (index < 0 || index > size) {
            System.out.println("Index out of bounds");
            return;
        }
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }
        Node node = new Node(val);
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node nextNode = temp.next;
        node.prev = temp;
        node.next = nextNode;

        temp.next = node;
        if (nextNode != null) {
            nextNode.prev = node;
        }
        size++;
    }

    public void deleteLast() {
        if (tail == null)
            return;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
    }

    public void deleteFirst() {
        if (head == null)
            return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size) {
            deleteLast();
            return;
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Node prevNode = temp.prev;
        Node nextNode = temp.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        size--;

    }

    public void display() {
        Node temp = head;
        Node last = null;
        while (temp != null) {
            System.out.print(temp.value + " ->");
            last = temp;
            temp = temp.next;
        }
        System.out.println("null");
        System.out.println("size " + size);
        System.out.println("reverse order");
        while (last != null) {
            System.out.print(last.value + " <-");
            last = last.prev;
        }
        System.out.println("Start");
    }

    class Node {
        int value;
        Node next;
        Node prev;

        public Node() {

        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
