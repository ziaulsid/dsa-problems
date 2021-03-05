import java.util.LinkedHashMap;
import java.util.Map;
/*The eviction policy is provided by the LinkedHashMap class itself. All we need to do is override removeEldestEntry(). This method is called before every put operation and 
If this method returns true the last recently used entry is deleted*/
class LRUCache extends LinkedHashMap<Integer, Integer> {

    private int capacity;
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key,-1);
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldestEntry){
        return super.size() > capacity;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
