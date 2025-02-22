package randomYT.Codebix;

public class HashMapImplementation {

	
	
}

class MyHashMap {
	private static final int SIZE = 100000;
	private Entry[] table;

	public MyHashMap() {
		table = new Entry[SIZE];
	}

	public void put(int key, int value) {
		int index = key % SIZE;
		Entry e = table[index];
		if (e == null) {
			table[index] = new Entry(key, value);
		} else {
			while (true) {
				if (e.key == key) {
					e.value = value;
					return;
				}
				if (e.next == null) {
					break;
				}
				e = e.next;
			}
			e.next = new Entry(key, value);
		}
	}

	public int get(int key) {
		int index = key % SIZE;
		Entry e = table[index];
		while (e != null) {
			if (e.key == key) {
				return e.value;
			}
			e = e.next;
		}
		return -1;
	}

	public void remove(int key) {
		int index = key % SIZE;
		Entry e = table[index];
		if (e == null) {
			return;
		}
		if (e.key == key) {
			table[index] = e.next;
		} else {
			while (e.next != null) {
				if (e.next.key == key) {
					e.next = e.next.next;
					return;
				}
				e = e.next;
			}
		}
	}

	private static class Entry {
		int key;
		int value;
		Entry next;

		Entry(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}
