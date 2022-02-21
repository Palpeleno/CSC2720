package labs.lab2;
/*Kush Darji
    CSC2720
    Lab 2
    Completed
*/
public class Main {
    public static void main(String[] args) {
        LinkedList myL1 = new LinkedList();

        myL1.addLast(2);
        myL1.addLast(4);
        myL1.addLast(8);
        myL1.addFirst(-2);
        myL1.addFirst(-8);
        myL1.addLast(9);
        myL1.print();
        System.out.println();
        System.out.println(myL1.indexOf(4));
        System.out.println(myL1.contains(9));
        myL1.reverse();
        myL1.print();
        myL1.reverse();
        System.out.println();
        for (int i = 0; i <= myL1.lengthOf();) {
            myL1.deleteLast();
            myL1.print();
            System.out.println();
        }

    }
}
