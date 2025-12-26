package Map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {


    private int capacity;
    public LRUCache(int capacity){
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()> capacity;
    }

    public static void main(String[] args) {
        LRUCache<String,Integer> studencache = new LRUCache<String,Integer>(3);
        studencache.put("Shubham", 91);
        studencache.put("Ankit", 80);
        studencache.put("Bablu", 70);
        studencache.put("Sandeep" ,45);
        studencache.put("Shubham" ,99);
        System.out.println(studencache);

    }
}
