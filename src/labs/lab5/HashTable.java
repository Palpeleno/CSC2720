package labs.lab5;

import java.util.LinkedList;

public class HashTable {
    private LinkedList<Entry>[] table;

    public HashTable(int capacity) {
        table = new LinkedList[capacity];
    }

    private class Entry {
        private int key;
        private String val;

        public Entry(int key, String val) {
            this.key = key;
            this.val = val;
        }
    }

    // adds an entry with the object key and value
    private void put(Integer key, String val) {

    }

    // returns the value(of type String) with the input key that is the key in the
    // hash table
    private void get(int key) {

        return toString.key();
    }

    // accepts input as some integer that is in the key and removes it from
    // hashtable
    private void remove(int key) {

    }

}
