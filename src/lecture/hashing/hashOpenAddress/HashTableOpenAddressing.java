package lecture.hashing.hashOpenAddress;


  public class HashTableOpenAddressing {
	private int size;
	private Entry[] table;

	public HashTableOpenAddressing(int capacity) {
		size = 0;
		table = new Entry[capacity];
	}

	public class Entry {
		private int key;
		private String val;

		public Entry(int key, String val) {
			this.key = key;
			this.val = val;
		}
	}

	public void put(int key, String val) {
		for (int i = 0; i < table.length; i++) {
			int index = linearProbing(key, i);
			if (table[index] == null) {
				table[index] = new Entry(key, val);
				size++;
				return;
			}
			if (table[index].key == Integer.MIN_VALUE) {
				table[index].key = key;
				table[index].val = val;
				size++;
				return;
			}
			if (table[index].key == key) {
				table[index].val = val;
				return;
			}
		}
		throw new IllegalStateException("Hash table is full!");
	}

	public String get(int key) {
		for (int i = 0; i < table.length; i++) {
			int index = linearProbing(key, i);
			if (table[index] == null) {
				break;
			}
			if (table[index].key == key) {
				return table[index].val;
			}
		}
		return null;
	}

	public void remove(int key) {
		for (int i = 0; i < table.length; i++) {
			int index = linearProbing(key, i);
			if (table[index] == null) {
				throw new IllegalStateException();
			}
			if (table[index].key == key) {
				size--;
				table[index].val = "";
				table[index].key = Integer.MIN_VALUE;
			}
		}
	}

	public int size() {
		return size;
	}

	public String toString() {
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < table.length; i++) {
			if (table[i] == null) {
				str.append("[]");
				continue;
			}
			if (table[i].key == Integer.MIN_VALUE) {
				str.append("[X]");
				continue;
			}
			str.append("[" + table[i].key + "=" + table[i].val + "]");
		}

		return str.toString();
	}

	private int linearProbing(int key, int i) {
		return (key + i) % table.length;
	}
}