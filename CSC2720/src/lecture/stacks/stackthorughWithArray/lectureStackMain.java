package lecture.stacks.stackthorughWithArray;

public class lectureStackMain {

    public static void main(String[] args) {
        lectruestack s = new lectruestack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
        System.out.println("Top element is :" + s.peek());
        System.out.print("Elements present in stack :");
        s.print();
    }
}