public class SLLMain {
    public static void main(String[] args) {
        // SLLMain singly = new SLLMain();
        SLLPractice singly = new SLLPractice();
        singly.insertAtFirst(18);
        singly.insertAtFirst(23);
        singly.insertAtFirst(43);
        singly.insertAtFirst(45);
        singly.insertAtEnd(32);
        singly.insertAtPosition(55, 2);
        singly.insertAtPosition(433,3);
        singly.display();
        singly.deleteAtStart();
        singly.display();
        singly.deleteAtEnd();
        singly.display();
        singly.deleteAtindex(2);
        singly.display();
        int ans =singly.Search(433);
        System.out.println("Element found at "+ans+" index");
        singly.updateValue(69, 1);
        singly.display();
        singly.ReverseInMemory();
        singly.display();
        singly.ReversePrinting(singly.head);
    }
}
