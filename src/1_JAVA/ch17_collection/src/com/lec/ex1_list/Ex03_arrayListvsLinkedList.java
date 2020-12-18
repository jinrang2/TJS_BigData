package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Ex03_arrayListvsLinkedList {
	
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		LinkedList<String> lList = new LinkedList<String>();
		
		System.out.println("arrayList  끝 인덱스로 추가 시간:"+addSeqTime(arr));
		System.out.println("LinkedList 끝 인덱스로 추가 시간:"+addSeqTime(lList));
		
		System.out.println("arrayList  중간 인덱스로 추가 시간:"+addRandTime(arr));
		System.out.println("LinkedList 중간 인덱스로 추가 시간:"+addRandTime(lList));
		
		System.out.println("arrayList  끝 부터 삭제 시간:"+removeSeqTime(arr));
		System.out.println("LinkedList 끝 부터 삭제  시간:"+removeSeqTime(lList));		
		
		System.out.println("arrayList  중간 무작위 삭제 시간:"+removeRandTime(arr));
		System.out.println("LinkedList 중간 무작위 삭제  시간:"+removeRandTime(lList));
	}
	
	private static long removeRandTime(List<String> list) {
		long start = System.currentTimeMillis();
		
		for (int i = 0 ; i < list.size() ; ++i) {
			list.remove(0);
		}
		
		long end = System.currentTimeMillis();		
		return end-start;
	}
	
	private static long removeSeqTime(List<String> list) {
		long start = System.currentTimeMillis();
		
		for (int i = list.size()-1 ; i > 2000 ; --i) {
			list.remove(i);
		}
		
		long end = System.currentTimeMillis();		
		return end-start;
	}
	
	private static long addRandTime(List<String> list) {
		long start = System.currentTimeMillis();
		
		for (int i = 0 ; i < 1000 ; ++i) {
			list.add(100,"중간에 추가");
		}
		
		long end = System.currentTimeMillis();		
		return end-start;
	}
	
	
	
	private static long addSeqTime(List<String> list) {
		long start = System.currentTimeMillis();
		
		for (int i = 0 ; i < 5000000 ; ++i) {
			list.add("순차적으로 추가");
		}
		
		long end = System.currentTimeMillis();		
		return end-start;
	}
}
