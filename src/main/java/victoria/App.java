import java.util.*;
import java.util.Arrays;

class LFUCache {

    // inner class to represent a node in Doubly LinkedList
    class Node {
        int key;
        int value;
        int freq;  // frequency of the key
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    // inner class to represent a Doubly LinkedList
    class DoublyLinkedList {
        Node head;
        Node tail;
        int size;

        public DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // add a new node at the beginning of the list
        public void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        // remove a node from the list
        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        // remove the last node from the list
        public Node removeLast() {
            if (tail.prev == head) {
                return null;
            }
            Node last = tail.prev;
            remove(last);
            return last;
        }
    }

    Map<Integer, Node> cache;  // to store nodes corresponding to a key
    Map<Integer, DoublyLinkedList> freqMap;  // to store Doubly LinkedLists corresponding to a frequency
    int capacity;
    int minFreq;  // minimum frequency in the cache

    public LFUCache(int capacity) {
        cache = new HashMap<>();
        freqMap = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {  // key not found
            return -1;
        }
        Node node = cache.get(key);
        update(node);  // update the frequency of the node
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {  // edge case
            return;
        }
        if (cache.containsKey(key)) {  // key already exists in the cache
            Node node = cache.get(key);
            node.value = value;  // update the value of the existing node
            update(node);  // update the frequency of the node
        } else {  // key does not exist in the cache
            if (cache.size() == capacity) {  // cache is full, need to evict a node
                DoublyLinkedList dll = freqMap.get(minFreq);  // get the Doubly LinkedList corresponding to minimum frequency
                Node evictedNode = dll.removeLast();  // remove the least frequently used node from the Doubly LinkedList
                cache.remove(evictedNode.key);  // remove the evicted node from the cache
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);  // add the new node to the cache
            DoublyLinkedList dll = freqMap.computeIfAbsent(1, k -> new DoublyLinkedList());  // get the Doubly LinkedList corresponding to frequency 1 or create a new one if it does not exist
            dll.addFirst(newNode);  // add the new node to the Doubly LinkedList corresponding to frequency 1
            minFreq = 1;  // reset the minFreq to 1 after adding a new node
        }
    }

    // utility function to update the frequency of a node
    private void update(Node node) {
        int freq = node.freq;
        DoublyLinkedList dll = freqMap.get(freq);  // get the Doubly LinkedList corresponding to the frequency of the node
        dll.remove(node);  // remove the node from its current Doubly LinkedList
        if (freq == minFreq && dll.size == 0) {  // update minFreq if necessary
            minFreq++;
        }
        node.freq++;  // increment the frequency of the node
        DoublyLinkedList newDll = freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList());  // get the Doubly LinkedList corresponding to the new frequency or create a new one if it does not exist
        newDll.addFirst(node);  // add the node to the Doubly LinkedList corresponding to its new frequency
    }
}
