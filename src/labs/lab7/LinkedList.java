package labs.lab7;

import java.util.HashSet;

public class LinkedList {
    private Node head;
    private Node tail;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;

        }
    }

    public void removeDuplicates() {
        System.out.println("Remove duplicates");
        HashSet<Integer> panipurri = new HashSet<>();

        Node current = head;
        Node previous = null;
        // until linked list is at the end becuse we can only pass through once
        while (current != null) {
            int currentvalue = current.value;

            // checks if value of the current node is in the hasset if not adds to to it
            if (panipurri.contains(currentvalue)) {
                // if already in set changes the linked list pointers so that from current to
                // next is not exist but still holds values from current to what will be next
                previous.next = current.next;
                // System.out.println("already in set\n" + panipurri.toString()); // debug
                // element

            } else {
                // System.out.println("because value was not in set"); // debug element
                panipurri.add(currentvalue);
                // assigns pointers so that the one we are right now is the main one and if we
                // step back previous will be a node value we already have stored and the next
                // will be whatever is next
                previous = current;
                // System.out.println("not in set so we adds value \n" + panipurri.toString());
                // // debug element
            }
            current = current.next;
        }

    }

    @Override
    public String toString() {
        Node current = head;
        StringBuffer toPrint = new StringBuffer();
        toPrint.append("[");
        while (current != null) {
            if (current.next != null) {
                toPrint.append(current.value + ", ");
            } else {
                toPrint.append(current.value);
            }
            current = current.next;
        }
        toPrint.append("]");
        return toPrint.toString();
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    private boolean isEmpty() {
        return (head == null);
    }

}
