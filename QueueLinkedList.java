public class QueueLinkedList {
    static class Node{
        int data ;
        Node next ;
        public Node(int data){
            this.data = data ;
            next = null ;
        }
    }
    static class Queue{
        static Node head = null;
        static Node tail = null ;

        public static boolean isEmpty(){
            return head == null && tail == null ;
        }
        //no need to check is full as we are using linked list

        public void add(int data){
            Node newNode = new Node(data) ;
            if(tail == null){//only for the first node 
                tail = head = newNode;
            }
            tail.next = newNode;
            tail = newNode ;
        }
        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int data = head.data;
            if(head == tail){ //only one node in the queue
                tail = null;
            }
            head = head.next;
            return data;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
            }
            return head.data;
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(12);
        q.add(15);
        q.add(20);
        q.add(21);
        q.add(25);
        System.out.println("Removed element is " + q.remove());
        // System.out.println(q.peek());
        while(!q.isEmpty()){
            System.out.println( q.peek());
            q.remove();
        }
    }
}
