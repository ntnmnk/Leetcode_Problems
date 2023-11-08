class MyHashMap {
    private static final int INITIAL_CAPACITY = 1000;
    private LinkedList<Entry>[] buckets;

    public MyHashMap() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int index = key % INITIAL_CAPACITY;
        LinkedList<Entry> bucket = buckets[index];
        for (Entry entry : bucket) {
            if (entry.key == key) {
                entry.value = value; // Update the existing value.
                return;
            }
        }
        bucket.add(new Entry(key, value));
    }

    public int get(int key) {
        int index = key % INITIAL_CAPACITY;
        LinkedList<Entry> bucket = buckets[index];
        for (Entry entry : bucket) {
            if (entry.key == key) {
                return entry.value; // Key found, return the corresponding value.
            }
        }
        return -1; // Key not found.
    }

    public void remove(int key) {
        int index = key % INITIAL_CAPACITY;
        LinkedList<Entry> bucket = buckets[index];
        Entry entryToRemove = null;
        for (Entry entry : bucket) {
            if (entry.key == key) {
                entryToRemove = entry;
                break;
            }
        }
        if (entryToRemove != null) {
            bucket.remove(entryToRemove);
        }
    }

    private static class Entry {
        int key;
        int value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */