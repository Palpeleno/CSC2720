package hw.hw1;

public class Array {
	private int[] elems;
	private int nElems;

	public Array(int size) {
		if (size < 0) {
			throw new IllegalArgumentException();
		}
		elems = new int[size];
	}

	public void print() {
		System.out.print("[");
		for (int i = 0; i < nElems; ++i)
			if (i < nElems - 1) {
				System.out.print(elems[i] + ", ");
			} else {
				System.out.print(elems[i]);
			}
		System.out.println("]");
	}

	public void insert(int element) {
		// if the array is full, increases its size
		if (elems.length == 0) {
			int[] extendedElems = new int[1];
			elems = extendedElems;
		}
		if (elems.length == nElems) {
			int[] extendedElems = new int[nElems * 2];
			for (int i = 0; i < nElems; ++i) {
				extendedElems[i] = elems[i];
			}
			elems = extendedElems;
		}
		// otherwise, adds a new element at the end
		elems[nElems] = element;
		nElems++;
	}

	public void removeAt(int index) {
		if (index < 0 || index >= nElems) {
			throw new IllegalArgumentException();
		} else {
			for (int i = index; i < nElems; ++i) {
				elems[i] = elems[i + 1];
			}
			nElems--;
		}
	}

	public int indexOf(int element) {
		for (int i = 0; i < nElems; ++i) {
			if (elems[i] == element) {
				return i;
			}
		}
		return -1;
	}

	public boolean contains(int element) {
		return (indexOf(element) != -1);
	}

	public int min() {
		// O(n): since the i variable will go through the whole array, until it reaches the length of array
		// the min number may be at the begining at worse case it will end up at the end of the array
		int first, second;
		int arr_size = elems.length;

		if (arr_size < 2) {
			System.out.println(" Invalid inpt");
		}

		first = second = Integer.MAX_VALUE;
		for (int i = 0; i < elems.length; i++) {
			if (elems[i] < first) {
				second = first;
				first = elems[i];
			} else if (elems[i] < second && elems[i] != first)
				second = elems[i];

		}

		return first;

	}

	public int[] reverse() {
		// O(n): the i varaible go through the array until the middle
		// the middle may be vary far from the beginning of the search 
		// or it might be closer to the begining of the search in both cases it will still be O(n)

		for (int i = 0; i < elems.length / 2; i++) {  // elem.length / 2 because it iterates until middle of array
			int temp = elems[i];
			elems[i] = elems[elems.length - i - 1];
			elems[elems.length - i - 1] = temp;

		}
		return elems;
	}
}