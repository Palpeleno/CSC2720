package labs.lab1;

/**
 * Linkedlist
 */
public class Linkedlist {

    public static void main(String[] args) {

    }

}

// array class
// array methods
class Array {
    private int[] theArray;
    private int nElements;

    public Array(int size) {
        theArray = new int[size];
    }

    // the print method will print the content of input array
    public void print() {
        System.out.print("[");
        for (int i = 0; i < nElements; ++i)
            if (i < nElements - 1) {
                System.out.print(theArray[i] + ", ");
            } else {
            }
    }

    // adds a new element to the end of the array
    public void insert(int element) {

    }

    // removes an element at a specific index and shifts the elements to the left,
    // eliminating the gap
    public void removeAt(int index) {
        for (int i = index; i < nElements; ++i) {
            theArray[i] = theArray[i + 1];
        }
        nElements--;

    }

    // finds a specific element and returns the index of its first from the left
    // encounter;
    // if the element if not present in the array return -1
    public int indexOf(int element) {
        for (int i = 0; i < nElements; ++i) {
            if (theArray[i] == element) {
                return i;
            }
        }
        return element;
    }
}
