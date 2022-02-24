package lecture.hashing;

//creation of node
class HashNode<K, V> {
    K key;
    V value;
    final int hashCode;

    // refrence to the next node
    HashNode<K, V> next;

    // constructor
    public HashNode(K key, V vlaue, int hashCode) {
        this.key = key;
        this.value = value;
        this.hashCode = hashCode;
    }
}

public class hashSepChain {

}
