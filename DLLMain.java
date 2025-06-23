public class DLLMain {
    public static void main(String[] args) {
        DLL doubly = new DLL();
        doubly.insertFirst(345);
        doubly.insertFirst(453);
        doubly.insertFirst(3);
        doubly.insertFirst(6);
        // doubly.display();
        doubly.insertLast(99);
        doubly.insertLast(90);
        // doubly.display();
        doubly.insertAtIndex(877, 5);
        // doubly.display();
        doubly.deleteLast();
        doubly.deleteFirst();
        doubly.display();
        doubly.deleteAtIndex(3);
        doubly.display();
        


    }
}
