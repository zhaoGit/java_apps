package com.zhaos.ehcache;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class MyService {

	@Resource(name = "testCache")
	private MyCache<String, String> myCache;
	
	public void saveData(String key, String valueString){
		myCache.set(key, valueString);
	}
	
	public String getData(String key){
		return myCache.get(key);
	}
}
