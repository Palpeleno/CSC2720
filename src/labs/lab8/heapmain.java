package labs.lab8;



public class heapmain{

    public static void main(String[] args) {
        
        Heap myheap = new Heap(5);
        
        myheap.insert(1);
        System.out.println(myheap.toString());


        myheap.insert(2);
        System.out.println(myheap.toString());

        myheap.insert(3);
        System.out.println(myheap.toString());

        myheap.insert(4);
        System.out.println(myheap.toString());

        myheap.insert(5);
        System.out.println(myheap.toString());

        myheap.insert(6);        
        System.out.println(myheap.toString());
      
    }
}