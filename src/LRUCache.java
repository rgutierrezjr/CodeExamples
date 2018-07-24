import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private final int capacity;

    private Map<Integer, Node> cacheElements = new HashMap();
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Removes the element at tail from Doubly Linked List as well as
     * cacheElements map.
     */
    private void removeTail() {
        cacheElements.remove(tail.key);

        tail = tail.previous;
        tail.next = null;
    }

    /**
     * Moves the input node to head of the doubly linked list.
     *
     * @param node Node to be moved
     */
    private void moveToHead(Node node) {
        // If node is already at head, do nothing and simply return
        if (node == head) {
            return;
        }

        // remove the node from LinkedList
        node.previous.next = node.next;
        if (node.next != null) {
            node.next.previous = node.previous;
        } else {
            tail = node.previous;
        }

        // put the node at head
        putAsHead(node);
    }

    /**
     * Puts the input node at head of the doubly linked list.
     *
     * @param node Node to be put on head
     */
    private void putAsHead(Node node) {
        node.next = head;
        node.previous = null;

        if (head != null) {
            head.previous = node;
        }

        head = node;

        if (tail == null) {
            tail = head;
        }
    }

    /**
     * Returns the value corresponding to input key from Cache Map. It also
     * moves this element to head of doubly linked list since it was most
     * recently accessed.
     */
    public int get(int key) {

        if (cacheElements.containsKey(key)) {
            final Node n = cacheElements.get(key);

            moveToHead(n);

            return n.value;
        }

        return -1;
    }

    /**
     * Put the element with input key and value in the cache. If the element
     * already exits, it updates its value. This method also removes the least
     * recently accessed element if the cache size has reached its capacity.
     */
    public void put(int key, int value) {
        if (cacheElements.containsKey(key)) {
            final Node old = cacheElements.get(key);
            old.value = value;

            moveToHead(old);
        } else {
            final Node created = new Node(key, value);

            if (cacheElements.size() >= capacity) {
                removeTail();
                putAsHead(created);
            } else {
                putAsHead(created);
            }

            cacheElements.put(key, created);
        }
    }

    /**
     * Implementation of a Node of a Doubly Linked List.
     */
    private static class Node {
        int key;
        int value;
        Node next;
        Node previous;

        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * Entry point for testing LRU Cache.
     */
    public static void main(String[] args) {
        // Create the cache with capacity 2
        LRUCache cache = new LRUCache(2);

        cache.put(2, 1); // Will add an element with key as 2 and value as 1
        cache.put(3, 2); // Will add an element with key as 3 and value as 2

        // Will add an element with key as 4 and value as 3. Also will remove
        // the element with key 2 as it was added least recently and cache can
        // just have two elements at a time
        cache.put(4, 3);

        // Since element with key 2 was removed, it will return null
        System.out.println(cache.get(2));

        // It will return value 2 and move the element with key 3 to the head.
        // After this point, element with key 4 will be least recently accessed
        System.out.println(cache.get(3));

        // Will add an element with key as 5 and value as 4. Also will remove
        // the element with key 4 as it was accessed least recently and cache
        // can just have two elements at a time
        cache.put(5, 4);

        // Since element with key 2 was removed, it will return null
        System.out.println(cache.get(4));
    }
}
