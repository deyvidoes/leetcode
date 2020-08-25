public class MyHashMap {
    private Map[] map;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        map = new Map[1000001];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        if(map[key] == null){
            map[key] = new Map(value);
        } else
            map[key].setValue(value);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        return map[key] == null ? -1 : map[key].getValue();
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        map[key] = null;
    }
}

class Map {
    int value;

    public Map(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */