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
}