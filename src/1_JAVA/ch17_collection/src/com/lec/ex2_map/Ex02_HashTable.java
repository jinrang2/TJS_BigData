package com.lec.ex2_map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

public class Ex02_HashTable {
	public static void main(String[] args) {
		Hashtable<String, String> ht = new Hashtable<String, String>();
		
		ht.put("010-9999-9999", "홍길동");
		ht.put("010-8888-8888", "김길동");
		ht.put("010-7777-7777", "박길동");
		ht.put("010-6666-6666", "윤길동");
		
		Iterator<String> iter = ht.keySet().iterator();
		
		while(iter.hasNext()) {
			String a = iter.next();
			System.out.println(a+"의 데이터는 "+ht.get(a));
		}
	}
}
