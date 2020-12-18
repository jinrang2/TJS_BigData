package com.lec.ex1_list;

import java.util.LinkedList;

public class Ex02_LinkedList {
	public static void main(String[] args) {
		LinkedList<String> lList = new LinkedList<String>();
		
		lList.add("str0");
		lList.add(1,"str1");
		lList.add(0,"str2");
		lList.add(1,"111111");
		
		//System.out.println(/;A);
		
		
		for(int idx = 0 ; idx < lList.size() ; ++idx) {
			System.out.println("arrayList["+idx+"]= " + lList.get(idx));
		}
		
		System.out.println(lList);
		lList.remove(1);
		System.out.println(lList);
		lList.clear();
		
		System.out.println(lList);
		
		if(lList.isEmpty()) {
			System.out.println("링크드리스트 지워짐");
			System.out.println(lList.toString());
		}	
	}
}
