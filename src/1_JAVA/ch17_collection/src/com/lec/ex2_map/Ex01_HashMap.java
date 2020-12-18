package com.lec.ex2_map;

import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {

	public static void main(String[] args) {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		Iterator<Integer> iter;
		
		hashMap.put(0, "Hong gildong");
		hashMap.put(1, "Kim dongil");
		hashMap.put(2, "Lee soonsin");
		hashMap.put(3, "Yu ain");
		
		
		System.out.println(hashMap.get(23));
		
		System.out.println("remove전 : "+hashMap);
		hashMap.remove(19);
		System.out.println("remove후 : "+hashMap);
		
		iter = hashMap.keySet().iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next()+"의 데이터는 "+hashMap.get(iter.next()));
		}
		
	}
}
