public class CircularQueue {
    static class CQueue{
         int size;
        static int[] arr;
        static int rear = -1;
        static int front = -1;

        CQueue(int size){
            this.size = size;
            arr = new int[size];
        }

        public  boolean isEmpty(){
            return rear==-1 && front==-1;
        }
        public  boolean isFull(){
            return (rear+1)%size == front;
        }
        public  void add(int data){ //O(1)
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            if(front==-1){
                front = 0 ;
            }
            rear=(rear+1)%size;
            arr[rear] = data;
        }
        public  int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int temp = arr[front];
            if(rear == front ){
                rear = front = -1;
            }else {
                front = (front+1)%size;
            }
            return temp;
        }
        public int peek(){
            if(isEmpty()){
                System.out.println("empty queue");
            }
            return arr[front];
        }

    }
    public static void main(String[] args) {
        CQueue q = new CQueue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        // q.add(9)
        q.remove();
        q.add(6);
            while(!q.isEmpty()){
                System.out.println(q.peek());
                q.remove();
            }

    }
}






