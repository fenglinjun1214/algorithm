import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapLru<K, V> extends LinkedHashMap<K,V> {

    public LinkedHashMapLru(int initialCapacity,
                            float loadFactor,
                            boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        if(size() > 4){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //给定一个hashMap
        LinkedHashMapLru<String, Integer> map =
                new LinkedHashMapLru<String, Integer>(16, 0.75f, true);

        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);
        map.put("key4", 4);
        map.put("key5", 5);
        map.put("key6", 6);
        map.get("key5");
        map.put("key7", 7);
        map.put("key8", 8);
        map.put("key9", 9);
        map.put("key10", 10);

    }
}