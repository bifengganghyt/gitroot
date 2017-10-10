package com.thread.lock.reentrantlock.condition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/*public class DataCache {
	
	public static  Condition getConditon(String requestId) {
		Condition condition = cacheservice.get(requestId);
		return  condition;
	}
	
	public static void setCondition(String requestId, Condition condition) {
		cacheservice.set(requestId, condition);
	}
}*/
public class DataCache {
	private static Map<String, Condition> map = new HashMap<String, Condition>();
	private static Map<String, Lock> map2 = new HashMap<String, Lock>();
	
	public static  Condition getConditon(String requestId) {
		return  map.get(requestId);
	}
	
	public static void setCondition(String requestId, Condition condition) {
		map.put(requestId, condition);
	}
	
	public static  Lock getLock(String requestId) {
		return  map2.get(requestId);
	}
	
	public static void setLock(String requestId, Lock lock) {
		map2.put(requestId, lock);
	}
}
