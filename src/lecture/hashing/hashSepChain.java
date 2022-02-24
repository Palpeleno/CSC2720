package lecture.hashing;

import java.util.ArrayList;
import java.util.Objects;

//creation of node
class HashNode<K, V> {
    K key;
    V value;
    final int hashCode;

    // refrence to the next node
    HashNode<K, V> next;

    // constructor
    public HashNode(K key, V value, int hashCode) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }
}

// this represent the hashtable
public class hashSepChain<K, V> {

    // bucketarray used to store array of chains
    private ArrayList<HashNode<K, V>> bucketArray;

    // cap of arraylist
    private int numBuckets;

    // size of array list
    private int size;

    public hashSepChain() {
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;

        // creates empty chains b/c it has null
        for (int i = 0; i < numBuckets; i++) {
            bucketArray.add(null);
        }

    }

    public int size() {
        return size;
    }

    public boolean isempty() {
        return size() == 0;
    }

    private final int hashCode(K key) {
        return Objects.hashCode(key);
    }

    private int getBucketIndex(K key) {
        int hashCode = hashCode(key);
        int index = hashCode % numBuckets;
        // key.hashCode() could be negative
        index = index < 0 ? index * -1 : index;
        return index;
    }

    // to get rid of key
    public V remove(K key) {
        // Apply hash functions to find index for given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);
        // Get head of chain
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        // Search for key in its chain
        HashNode<K, V> prev = null;
        while (head != null) {
            // If Key found
            if (head.key.equals(key) && hashCode == head.hashCode)
                break;

            // Else keep moving in chain
            prev = head;
            head = head.next;
        }

        // If key was not there
        if (head == null)
            return null;

        // Reduce size
        size--;

        // Remove key
        if (prev != null)
            prev.next = head.next;
        else
            bucketArray.set(bucketIndex, head.next);

        return head.value;

    }

    public V get(K key) {
        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);

        // construct new HashNode for retrival
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

    // add a key value pair to the hash
    public void add(K key, V value) {
        // fidn head of chain for given key

        int bucketIndex = getBucketIndex(key);
        int hashCode = hashCode(key);

        HashNode<K, V> head = bucketArray.get(bucketIndex);

        // check if key is already present if so creates or add to chain
        while (head != null) { // this condition is b/c wwe alreaduy created the hash with nulls
            if (head.key.equals(key) && head.hashCode == hashCode) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // insert key in chain if key doesnt exist
        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<K, V>(key, value, hashCode);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);

        // if load factor goes beyond threshold, then
        // double hash tabel size
        if((1.0*size) / numBuckets >= .7){
            //construct new list
            ArrayList<HashNode<K, V>> temp = bucketArray;

            bucketArray = new ArrayList<>();
            numBuckets = 2*numBuckets;
            size = 0;
            for (int i = 0; i <numBuckets; i++) {
                bucketArray.add(null);
            }
            for(){
                while (condition) {
                    
                }
            }


        }
    }
}
