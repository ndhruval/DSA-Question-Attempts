
class LRUCache {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        
        // Initialize LinkedHashMap with accessOrder set to true for LRU ordering
        this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            // Override the removeEldestEntry method to implement LRU eviction policy
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > LRUCache.this.capacity;
            }
        };
    }
    
    public int get(int key) {
        // Retrieve the value if present; return -1 otherwise
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
}
