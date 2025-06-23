public class StackLinkedList {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
       System.out.println( stack.isEmpty());
       stack.display();
       stack.pop();
       stack.display();
       stack.peek();
       stack.display();
    }
}

class Stack {
    private Node top;

    Stack() {

    }

    void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
        System.out.println("Pushed data:" + data);
    }
    int pop (){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        
        int data = top.data;
        top = top.next;
        System.out.println("Popped data:"+data);
        return data;
    }
    int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        int data = top.data;
        System.out.println("top data:"+data);
        return -1;
    }

    boolean isEmpty() {
        return top == null;
    }

    void display() {
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        Node temp = top;
        while(temp!=null){
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
