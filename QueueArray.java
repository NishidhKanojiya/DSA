public class QueueArray {

    static class Queue{
        static int arr[];
        static int size;
        static int rear =-1;
        
        Queue(int size){
            arr = new int[size];
            this.size = size;
        }

        public  boolean isEmpty(){
            return rear == -1;
        }

        //add(enque)
        public  void add(int data){
            if(rear ==size-1){
                System.out.println("Queue is full");
                return;
            }
            rear++;
            arr[rear]=data;
        }

        //remove (deque) O(n)
        public  int remove(){
            if(isEmpty()){
                return -1;
            }
            int front = arr[0];
            for(int i=0; i<rear;i++){
                arr[i]=arr[i+1];//or start from int i=1 and logic : arr[i-1]=arr[i];
            }
            rear--;
            return front;
        }
        //peek (front)
        public  int peek(){
            if(isEmpty()){
                return -1;
            }
            return arr[0];
        }
    }
    public static void main(String[] args) {
      Queue q = new Queue(5);
      q.add(1);//we can also access it like classname.methodname coz the class is declared as static and the methods are also static 
      q.add(2);
      q.add(3);
      q.add(4);
      
      while(!q.isEmpty()){
        System.out.println(q.peek());
        q.remove();
      }
      

    //   System.out.println(q.isEmpty());

    }
}

