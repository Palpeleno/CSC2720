package lecture.stacks.stackAsLinkedList;

public class stackAsLinkedListMain {

    public static void main(String[] args) {

        stackAsLinkedList sll = new stackAsLinkedList();
        sll.push(10);
        sll.push(20);
        sll.push(30);
        System.out.println(sll.pop()
                + " popped from stack");
        System.out.println("Top element is " + sll.peek());
    }
}
