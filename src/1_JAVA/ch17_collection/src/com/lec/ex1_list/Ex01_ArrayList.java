package com.lec.ex1_list;

import java.util.ArrayList;

public class Ex01_ArrayList {
	public static void main(String[] args) {
		String[] array  = new String[3];
		
		array[0] = "str0";
		array[1] = "str1";
		array[2] = "str2";
		
		for(int idx = 0 ; idx < array.length ; ++idx) {
			System.out.println("array["+idx+"]= " + array[idx]);
		}
		
		for (String arr : array) {
			System.out.println(arr);
		}
		
		System.out.println();
			
		ArrayList<String> arrayList = new ArrayList<String>();
		
		arrayList.add("str0");
		arrayList.add(1,"str1");
		arrayList.add(0,"str2");
		
		
		for(int idx = 0 ; idx < arrayList.size() ; ++idx) {
			System.out.println("arrayList["+idx+"]= " + arrayList.get(idx));
		}
		
		System.out.println(arrayList);
		arrayList.remove(1);
		System.out.println(arrayList);
		arrayList.clear();
		
		System.out.println(arrayList);
		
		if(arrayList.isEmpty()) {
			System.out.println("어레이리스트 지워짐");
			System.out.println(arrayList.toString());
		}
		
		
		
		arrayList =null;
		
		System.out.println(arrayList);
				
				
				
		
		for (String arr : arrayList) {
			System.out.println(arr);
		}
		
	}
}
