
import java.security.DrbgParameters.Capability;class ListNode{
    int key;
    int value;
    ListNode prev;
    ListNode next;

    public ListNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    // key, capacity
    private Map<Integer, ListNode> dict;
    private int capacity;
    // dummy node
    ListNode head;
    ListNode tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.dict = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head; 
    }
    
    public int get(int key) {
        if(!dict.containsKey(key)){
            return -1;
        }
        // contais Key
        ListNode node = dict.get(key);
        // remove and add to the tail
        remove(node);
        add(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(dict.containsKey(key)){
            ListNode node = dict.get(key);
            node.value = value;
            remove(node);
            add(node);
            return; // must return, not execute the below logic
        }

        //add the new node that's not in HashMap
            ListNode node = new ListNode(key, value);
            add(node);
            dict.put(key, node);

        //check capacity after insert node node
        if(dict.size() > capacity){
            ListNode previousHead = head.next;
            // remove head
            remove(previousHead);
            // remove the value in hashmap as well
            dict.remove(previousHead.key);
        }

        
    }
    public void remove(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void add(ListNode node){
        // find the tail node
        ListNode previousEnd = tail.prev;
        previousEnd.next = node;
        node.prev = previousEnd;

        // add dummy node
        node.next = tail;
        tail.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */