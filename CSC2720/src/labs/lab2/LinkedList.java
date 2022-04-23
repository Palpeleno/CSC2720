package labs.lab2;
/*Kush Darji
    CSC2720
    Lab 2
    Completed
*/

import java.util.NoSuchElementException;

public class LinkedList {
    private Node head; // first
    private Node tail; // last

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private boolean takeStep(Node node) {
        return (node.next != null);
    }

    private boolean nodeIsEmpty() {
        return (head == null);
    }

    public Node previousNode(Node node) {
        if (nodeIsEmpty())
            throw new NoSuchElementException();
        Node current = head;
        while (current.next != node) {
            if (!takeStep(current)) {
                throw new NoSuchElementException();
            }
            current = current.next;
        }
        return current;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            if (takeStep(current)) {
                System.out.print(current.value + ", ");
            } else {
                System.out.print(current.value);
            }
            current = current.next;
        }
    }

    public void addFirst(int value) {
        Node node = new Node(value);
        if (nodeIsEmpty()) { // T = [head],[current],[tail]-[head],[current],[tail]
            head = tail = node;
        } else {
            node.next = head; // [head],[current],[tail]-[],[current]->,[head]
            head = node;
        }
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (nodeIsEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public int indexOf(int value) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public int lengthOf() {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public boolean contains(int value) {
        return (indexOf(value) != -1);
    }

    public void deleteFirst() {
        if (nodeIsEmpty()) {
            throw new NoSuchElementException();
        }
        if (head == tail) {
            head = tail = null;
            return;
        }
        Node formerHeadNext = head.next;
        head.next = null;
        head = formerHeadNext;
    }

    public void deleteLast() {
        if (nodeIsEmpty())
            throw new NoSuchElementException();
        if (head == tail) {
            head = tail = null;
            return;
        }
        Node SecondToLastNode = previousNode(tail);
        SecondToLastNode.next = null;
        tail = SecondToLastNode;
    }

    Node reverse() {
        Node previousNode = null;
        Node current = head;
        Node next = null;

        while(current != null){
            next = current.next;
            current.next = previousNode;
            previousNode = current;
            current = next;
        }
        head = previousNode;
        return head;
    }
}