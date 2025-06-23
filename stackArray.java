public class stackArray {
    public static void main(String[] args) {
        // System.out.println("");
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack.peek());
        // stack.pop();
        System.out.println(stack.peek());
        System.out.println((stack.isEmpty()));
        stack.display();


    }
}

class Stack {
    int[] stack;
    int top = -1;
    
    Stack(){
        stack = new int[10];
    }

    void push (int data){
        if(top == stack.length - 1){
            System.out.println("Stack is full");
            return;
         }
         stack[++top]=data;
    }
    int peek(){
        if(top==-1)return -1;
        return stack[top];
    }

    int pop(){
        if(isEmpty()){
            System.out.println("Empty");
            return 1;
        }
            return stack[top--];
    }

    boolean isEmpty(){
       return top == -1;//btw if statement is not written in the line but this statement checks that 
                        //if top==-1 then it is empty return true otherwise false
    }
    void display(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Stack");
        for(int i=top; i>=0;i--){
            System.out.println(stack[i] +" ");
        }
        System.out.println();
    }

}




    


