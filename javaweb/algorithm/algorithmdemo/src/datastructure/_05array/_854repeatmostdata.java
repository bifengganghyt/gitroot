package datastructure._05array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class _854repeatmostdata {
	public static int findMostFrequestInArray(int[] arr) {
		int result = 0;
		int size = arr.length;
		if(size==0) {
			return Integer.MAX_VALUE;
		}
		//记录每个元素出现的次数
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<size;i++) {
			if(map.containsKey(arr[i])) {
				map.put(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		
		//找出出现次数最多的元素
		int most = 0;
		
		Set<Integer> keySet = map.keySet();
		//map的遍历方式1
		/*Iterator<Integer> iterator = keySet.iterator();
		while(iterator.hasNext()) {
			Integer key = iterator.next();
			Integer value = map.get(key);
			if(value>most) {
				most = value;
				result = key;
			}
		}*/
		//map的遍历方式2
		Set<Entry<Integer, Integer>> entrySet = map.entrySet();
		Iterator<Entry<Integer, Integer>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Entry<Integer, Integer> next = iterator.next();
			Integer key = next.getKey();
			Integer value = next.getValue();
			if(value>most) {
				most = value;
				result = key;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int arr[] = {1,5,4,3,4,4,5,4,5,5,6,6,6,6,6};
		int result = findMostFrequestInArray(arr);
		System.out.println(result);
	}
}
