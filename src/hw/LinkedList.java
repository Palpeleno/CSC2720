package hw;

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

	private boolean isEmpty() {
		return (head == null);
	}

	private boolean hasNext(Node node) {
		return (node.next != null);
	}

	public void print() {
		Node current = head;
		System.out.print("[");

		while (current != null) {
			if (hasNext(current)) {
				System.out.print(current.value + ", ");
			} else {
				System.out.print(current.value);
			}
			current = current.next;
		}

		System.out.println("]");
	}

	public void addFirst(int value) {
		Node node = new Node(value);

		if (isEmpty()) {
			head = tail = node;
		} else {
			node.next = head;
			head = node;
		}
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

	public boolean contains(int value) {
		return (indexOf(value) != -1);
	}

	public void deleteFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		if (head == tail) {
			head = tail = null;
			return;
		}
		Node second = head.next;
		head.next = null;
		head = second;
	}

	public Node previous(Node node) {
		if (isEmpty())
			throw new NoSuchElementException();
		Node current = head;
		while (current.next != node) {
			if (!hasNext(current)) {
				throw new NoSuchElementException();
			}
			current = current.next;
		}
		return current;
	}

	public void deleteLast() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		if (head == tail) {
			head = tail = null;
			return;
		}
		Node lastButOne = previous(tail);
		lastButOne.next = null;
		tail = lastButOne;
	}

	public int getKthNodeFromTheEnd(int k) {
		if (isEmpty()) {
			throw new IllegalStateException();
		}
		if (k <= 0) {
			throw new IllegalArgumentException();
		}
		Node first = head;
		Node second = head;
		for (int i = 0; i < k - 1; i++) {
			if (!hasNext(first)) {
				throw new IllegalArgumentException();
			}
			first = first.next;
		}
		while (first != tail) {
			first = first.next;
			second = second.next;
		}
		return second.value;
	}

}
