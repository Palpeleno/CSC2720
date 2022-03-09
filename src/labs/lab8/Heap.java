package labs.lab8;

import java.util.Arrays;

public class Heap {
	private int[] items;
	private int size;

	public Heap(int capasity) {
		items = new int[capasity];
	}
	
	public String toString() {
		var content = Arrays.copyOfRange(items, 0, size);
		return Arrays.toString(content);
	}

	public int remove() {
		if(isEmpty()) {
			throw new IllegalStateException();
		}
		
		int root = items[0];
		items[0] = items[size - 1];
		size--;
		bubbleDown();
		return root;
	}
	
	private void bubbleDown() {
		int index = 0;
		while (index <= size && !isValidParent(index)) {
			int largerChildIndex = largerChildIndex(index);
			swapTwoItemsAt(index, largerChildIndex);
			index = largerChildIndex;
		}
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private boolean hasLeftChild(int index) {
		return leftChildIndex(index) <= size;
	}
	
	private boolean hasRightChild(int index) {
		return rightChildIndex(index) <= size;
	}
	
	private int largerChildIndex(int index) {
		if(!hasLeftChild(index)) {
			return index;
		}
		
		if(!hasRightChild(index)) {
			return leftChildIndex(index);
		}
		
		return (leftChild(index) > rightChild(index)) ? 
				leftChildIndex(index) : rightChildIndex(index);
	}

	private boolean isValidParent(int index) {
		if(!hasLeftChild(index)) {
			return true;
		}
		
		boolean isValid = (items[index] >= leftChild(index));
		if(hasRightChild(index)) {
			isValid &= (items[index] >= rightChild(index));
		}
		return isValid;
	}

	private int leftChild(int index) {
		return items[leftChildIndex(index)];
	}

	private int rightChild(int index) {
		return items[rightChildIndex(index)];
	}

	private int leftChildIndex(int index) {
		return index * 2 + 1;
	}

	private int rightChildIndex(int index) {
		return index * 2 + 2;
	}
	
}
