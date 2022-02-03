package labs.lab4;

public class main {
    public static void main(String[] args) {

        QueueStack a = new QueueStack();

        a.enQueue(1);
        a.enQueue(2);
        a.enQueue(3);
        a.enQueue(4);

        System.out.println(a.deQueue());
        System.out.println(a.deQueue());
        System.out.println(a.deQueue());
        System.out.println(a.deQueue());

    }

}
