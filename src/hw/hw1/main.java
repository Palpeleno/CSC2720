package hw;

public class main {
    public static void main(String[] args) {
        int length = 6;
        Array arr = new Array(length);
        for (int i = -3; i < length - 3; i++) {
            arr.insert(i);
        }

        // problem 1.a System.out.println(arr.min());
        // problem 1.b  arr.reverse(); arr.print();
        
        LinkedList list = new LinkedList();
        for (int i = 0; i < length; i++) {
            list.addFirst(i);
        }
       



        // problem 2 
        list.printMiddle(); 
        list.deleteLast(); 
        list.printMiddle();

     

        
    }
}
