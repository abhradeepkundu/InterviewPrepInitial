package threadkb;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {

	private Map<String, String> _cache = null;
	private final int CAPACITY;
	
	public LRU(int capacity) {
		CAPACITY = capacity;
		_cache = new LinkedHashMap<String, String>(capacity, 0.75f, true) {
			
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return size() > CAPACITY;
			}
		};
	}
	
	public String get(String key) {
		return _cache.getOrDefault(key, "NA");
	}
	public void set(String key, String val) {
		_cache.put(key, val);
	}
	
	public static void main(String[] args) {
		//Collections.synchronizedMap(m)
		// TODO Auto-generated method stub
		LRU lru = new LRU(4);
		lru.set("1", "1");
		lru.set("2", "2");
		lru.set("3", "3");
		
		lru.set("4", "4");
		lru.set("5", "5");
		System.out.println(lru.get("1"));
		System.out.println(lru);
		lru.get("2");
		lru.set("6", "6");
		System.out.println(lru.get("2"));
		System.out.println(lru.get("3"));
		System.out.println(lru);
	}

}
