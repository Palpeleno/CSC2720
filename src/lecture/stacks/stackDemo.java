package lecture.stacks;

import java.util.Stack;

public class stackDemo {

    public static void main(String[] args) {

        // Default initialization of Stack
        stackDemo stack1 = new stackDemo();

        // Initialization of Stack
        // using Generics
        Stack<String> stack2 = new Stack()<String>();

        // pushing the elements
        stack1.push(4);
        stack1.push("All");
        stack1.push("Geeks");
        stack2.push("Geeks");
        stack2.push("For");
        stack2.push("Geeks");

        // Printing the Stack Elements
        System.out.println(stack1);
        System.out.println(stack2);

        // Fetching the element at the head of the Stack
        System.out.println("The element at the top of the"
                + " stack is: " + stack2.peek());
        // Removing elements using pop() method
        System.out.println("Popped element: "
                + stack2.pop());
    }

}
