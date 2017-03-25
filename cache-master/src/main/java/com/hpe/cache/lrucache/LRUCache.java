package com.hpe.cache.lrucache;

import com.hpe.cache.interf.CacheInterface;
import java.util.LinkedHashMap;
import java.util.Map;




public class LRUCache extends LinkedHashMap<Integer, String> implements CacheInterface {

	  private static final long serialVersionUID = 1L;
	  private int capacity;

	
	public LRUCache(int capacity){
		   super(capacity+1, 1.0f, true); 
	       this.capacity = capacity;
	   }
	
	@Override
	   protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest){
	      return size() > this.capacity;
	   }

@Override
	public boolean delCache(int key) {
		String s;
		s=remove(key);
		if(s == null)
			return false;
		
		return true;
		
	}

	@Override
	public boolean update(int key, String value) {

		if (containsKey(key)) {
			put(key, value);
			return true;
		} else {
			return false;
		}

	}
	
	@Override
	public void addCache(int key, String value) {

            put(key, value);
              	
	}

	@Override
	public String getCache(int key) {
		return get(key);
		
	}

}
