package labs.lab7;

import labs.lab7.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList alpha = new LinkedList();

        alpha.addLast(1);
        alpha.addLast(2);
        alpha.addLast(3);
        alpha.addLast(2);
        alpha.addLast(1);
        alpha.addLast(3);

        System.out.println(alpha.toString());
        

        alpha.removeDuplicates();
        System.out.println(alpha.toString());

    }
}