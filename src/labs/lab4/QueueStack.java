package labs.lab4;

import java.util.Stack;

public class QueueStack {

    private Stack<Integer> stackEat;
    private Stack<Integer> stackRegerg;

    public QueueStack(){
        stackEat = new Stack<>();
        stackRegerg = new Stack<>();
    }

    public void enQueue(int food){
        // Push item into s1
        stackEat.push(food);
        
    }

    // Dequeue an item from the queue
    public int deQueue() {
        // if first stack is empty
        if (stackEat.isEmpty()) {
            System.out.println("Q is Empty");
            System.exit(0);
        }

        // Return top of stackEat
        int x = stackEat.peek();
        stackEat.pop();
        return x;
    }

    public boolean isEmpty(){
        return stackEat.isEmpty() && stackRegerg.isEmpty();
    }

    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();

        if (stackRegerg.isEmpty()) {
            int x = stackEat.peek();
            stackEat.pop();
            return x;
        }
        return stackRegerg.peek();
    }
}
