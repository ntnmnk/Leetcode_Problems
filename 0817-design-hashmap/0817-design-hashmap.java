class MyHashMap {
    private static  int INITIAL_CAPACITY = 16; // Initial capacity of the array
    private static  double LOAD_FACTOR = 0.75; // Load factor threshold for resizing

    private int size; // Number of key-value pairs in the hashmap
    private List<Entry>[] buckets;

    public MyHashMap() {
        size = 0;
        buckets = new ArrayList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    public void put(int key, int value) {
        int index = key % INITIAL_CAPACITY;
        List<Entry> bucket = buckets[index];
        for (Entry entry : bucket) {
            if (entry.key == key) {
                entry.value = value; // Update the existing value.
                return;
            }
        }
        bucket.add(new Entry(key, value));
        size++;

        // Check if resizing is needed
        if ((double)size / INITIAL_CAPACITY > LOAD_FACTOR) {
            resize();
        }
    }

    public int get(int key) {
        int index = key % INITIAL_CAPACITY;
        List<Entry> bucket = buckets[index];
        for (Entry entry : bucket) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return -1; // Key not found.
    }

    public void remove(int key) {
        int index = key % INITIAL_CAPACITY;
        List<Entry> bucket = buckets[index];
        for (Entry entry : bucket) {
            if (entry.key == key) {
                bucket.remove(entry);
                size--;
                return;
            }
        }
    }

    private void resize() {
        int newCapacity = INITIAL_CAPACITY * 2;
        List<Entry>[] newBuckets = new ArrayList[newCapacity];
        for (int i = 0; i < newCapacity; i++) {
            newBuckets[i] = new ArrayList<>();
        }

        // Rehash and redistribute the entries
        for (List<Entry> bucket : buckets) {
            for (Entry entry : bucket) {
                int newIndex = entry.key % newCapacity;
                newBuckets[newIndex].add(entry);
            }
        }

        // Update the hashmap's data
        buckets = newBuckets;
        INITIAL_CAPACITY = newCapacity;
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