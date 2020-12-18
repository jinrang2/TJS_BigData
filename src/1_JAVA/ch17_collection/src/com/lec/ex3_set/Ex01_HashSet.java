package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01_HashSet {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		
		hs.add("str0");
		hs.add("str1");
		hs.add("str2");
		hs.add("str3");
		
		System.out.println(hs);
		System.out.println("hashset 사이즈 : "+hs.size());
		hs.add("str2");
		System.out.println(hs);
		System.out.println("hashset 사이즈 : "+hs.size());
		
		Iterator<String> iter;
	}
}
