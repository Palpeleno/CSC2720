package hw.hw3;

public class Main {
    //returns true of min heap else false
    public static boolean isMinHeap(int[] array) {

        int a = array.length - 1;

        // children index = (n/2-1)
        // check if parent is greater than children

        for (int b = (a / 2 - 1); b >= 0; b--) {
            // left child index = 2*b+1
            // Right child index = 2*b+2
            if (array[b] > array[2 * b + 1])
                return false;
            if (2 * b + 2 < a) {
                // if parent is greater than right child
                if (array[b] > array[2 * b + 2]) {
                    return false;
                }

            }
        }

        return true;

    }

    public static void main(String[] args) {
        //multiple test for isMinHeap
        int[] array1 = { 1,3,2,8,10,9 };
        int[] array2 = { 1,3,2,8,2,10 };
        int[] array3 = { 0,3,2,8,10,9,7};

        System.out.println(isMinHeap(array1));
        System.out.println(isMinHeap(array2));
        System.out.println(isMinHeap(array3));

        Tree tree = new Tree();

        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(5);
        tree.insert(6);

        // tree.printNodesDecreasing();
        System.out.println();
        // tree.printLeaves();
    }

}
