package labs.lab5;

import java.util.ArrayList;
import java.util.Objects;

public class HashTable<K,V> {

        // bucketArray is used to store array of chains
        private ArrayList<HashNode<K, V>> bucketArray;

        // Current capacity of array list
        private int numBuckets;

        private int currentSize;

        // Constructor (
        public HashTable() {
            bucketArray = new ArrayList<>();
            numBuckets = 10;
            currentSize = 0;

            for (int i = 0; i < numBuckets; i++)
                bucketArray.add(null);
        }

        public int size() {
            return currentSize;
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        private final int hashCode(K key) {
            return Objects.hashCode(key);
        }

        // This implements hash function to find index
        private int getBucketIndex(K key) {
            int hashCode = hashCode(key);
            int index = hashCode % numBuckets;
            index = index < 0 ? index * -1 : index;
            return index;
        }

        // Method to remove a given key
        public V remove(K key) {
            // Apply hash function to find index for given key
            int bucketIndex = getBucketIndex(key);
            int hashCode = hashCode(key);
            HashNode<K, V> head = bucketArray.get(bucketIndex);

            HashNode<K, V> prev = null;
            while (head != null) {
                if (head.key.equals(key) && hashCode == head.hashCode)
                    break;

                prev = head;
                head = head.next;
            }

            if (head == null)
                return null;

                currentSize--;

            // Remove key
            if (prev != null)
                prev.next = head.next;
            else
                bucketArray.set(bucketIndex, head.next);

            return head.value;
        }

        // Returns value for a key
        public V get(K key) {
            // Find head of chain for given key
            int bucketIndex = getBucketIndex(key);
            int hashCode = hashCode(key);

            HashNode<K, V> head = bucketArray.get(bucketIndex);

            // Search key in chain
            while (head != null) {
                if (head.key.equals(key) && head.hashCode == hashCode)
                    return head.value;
                head = head.next;
            }

            // If key not found
            return null;
        }

        // Put a key value pair to hash
        public void put(K key, V value) {
            // Find head of chain for given key
            int bucketIndex = getBucketIndex(key);
            int hashCode = hashCode(key);
            HashNode<K, V> head = bucketArray.get(bucketIndex);

            // Check if key is already present
            while (head != null) {
                if (head.key.equals(key) && head.hashCode == hashCode) {
                    head.value = value;
                    return;
                }
                head = head.next;
            }

            // Insert key in chain
            currentSize++;
            head = bucketArray.get(bucketIndex);
            HashNode<K, V> newNode = new HashNode<K, V>(key, value, hashCode);
            newNode.next = head;
            bucketArray.set(bucketIndex, newNode);

            // If load factor goes beyond threshold, then
            // double hash table size
            if ((1.0 * currentSize) / numBuckets >= 0.7) {
                ArrayList<HashNode<K, V>> temp = bucketArray;
                bucketArray = new ArrayList<>();
                numBuckets = 2 * numBuckets;
                currentSize = 0;
                for (int i = 0; i < numBuckets; i++)
                    bucketArray.add(null);

                for (HashNode<K, V> headNode : temp) {
                    while (headNode != null) {
                        put(headNode.key, headNode.value);
                        headNode = headNode.next;
                    }
                }
            }
        }

    }

class HashNode<K, V> {
    K key;
    V value;
      final int hashCode;
 
    // Reference to next node
    HashNode<K, V> next;
 
    // Constructor
    public HashNode(K key, V value, int hashCode)
    {
        this.key = key;
        this.value = value;
          this.hashCode = hashCode;
    }
}
