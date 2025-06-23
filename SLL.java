public class SLL {

    private Node head;
    private Node tail;
    private int size;

    public SLL() {
        this.size = 0;
    }

    public void insertFirst(int val) {  
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void insertEnd(int val) {
        Node node = new Node(val);
        if (tail == null) {
            insertFirst(val);
            return;
        } else {
            tail.next = node;
            tail = node;
            size++;
        }
        display();
    }

    public void insertPosition(int val, int index) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertEnd(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            size--;

        }
    }
    public void deleteEnd() {
        if(tail==null){
            System.out.println("List is empty");

        }
        else{
            Node temp = head;
            while (temp.next != tail) {
                temp = temp.next;
                }
                temp.next = null;
                tail = temp;
                size--;
        }
    }
    public int  deletePosition(int index) {
        Node prev=get(index);
        int value = prev.next.value;
        prev.next = prev.next.next;
        return value;
    }
    public Node get(int index){
        Node node =head;
        for (int i = 0; i < index; i++) {
            node = node.next;  
        }
        return node;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ->");
            temp = temp.next;
        }
        System.out.println("end");
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;

        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

}
