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
		if (isEmpty()) {
			throw new IllegalStateException();
		}

		int root = items[0];
		items[0] = items[size - 1];
		size--;
		bubbleDown();
		return root;
	}

	public void insert(int value) {
		//if heap empty add to it 
		if (size == items.length) {
			size++;
		}
		size++;
		items[size - 1] = value;
		bubbleUp(size - 1);

		
	}

	private void bubbleUp(int itemIndex){
		int parentIndex, temp;
		if(itemIndex != 0){
			parentIndex = parentIndex(itemIndex);
			if (items[parentIndex]>items[itemIndex]) {
				temp = items[parentIndex];
				items[parentIndex]=items[itemIndex];
				items[itemIndex]=temp;
				bubbleUp(parentIndex);
			}
		}

	}

	private void bubbleDown() {
		int index = 0;
		while (index <= size && !isValidParent(index)) {
			int largerChildIndex = largerChildIndex(index);
			swapTwoItemsAt(index, largerChildIndex);
			index = largerChildIndex;
		}
	}

	private void swapTwoItemsAt(int index, int largerChildIndex) {
		int temp;
		temp = index;
		index = largerChildIndex;
		largerChildIndex = temp;
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
		if (!hasLeftChild(index)) {
			return index;
		}

		if (!hasRightChild(index)) {
			return leftChildIndex(index);
		}

		return (leftChild(index) > rightChild(index)) ? leftChildIndex(index) : rightChildIndex(index);
	}

	private boolean isValidParent(int index) {
		if (!hasLeftChild(index)) {
			return true;
		}

		boolean isValid = (items[index] >= leftChild(index));
		if (hasRightChild(index)) {
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

	//add this to kno where to bubble up too
	private int parent(int index){
		return items[parentIndex(index)];
	}

	private int leftChildIndex(int index) {
		return index * 2 + 1;
	}

	private int rightChildIndex(int index) {
		return index * 2 + 2;
	}

	//add to know index where to bubble up too
	private int parentIndex(int index) {
		return (index - 1) / 2;

	}

}
