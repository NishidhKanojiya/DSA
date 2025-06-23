
//LIFO ds Stack and Queue is FIFO
//no efficient queue can be implemented using stack
//no efficient means all the operations are O(1)

//2 ways to do this 
//1. push will be O(1) and pop will be O(n) and peek will also be O(n)
//2. push will be O(n) and pop will be O(1) and peek will be O(1)
import java.util.Stack;

public class QueueUsing2Stacks {
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();


        public   boolean isEmpty(){
            return s1.isEmpty() && s2.isEmpty();
        }
        public  void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        public  int remove(){
            if(s1.isEmpty()){
                return -1;
            }
            return s1.pop();
        }
        public  int peek(){
            if(s1.isEmpty()){
                return -1;
            }
            return s1.peek();
        }

    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(34);
        q.add(6);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
        System.out.println(q.s1);
    }
}
