package labs.lab4;

public class main {
    public static void main(String[] args) {

        QueueStack a = new QueueStack();

        a.push(1);
        a.push(2);
        a.push(3);
        a.push(4);

        System.out.println("current size: " + a.size());
        System.out.println(a.top());
        a.pop();
        System.out.println(a.top());
        a.pop();
        System.out.println(a.top());
        a.pop();
        System.out.println(a.top());
 
        System.out.println("current size: " + a.size());

    }

}
