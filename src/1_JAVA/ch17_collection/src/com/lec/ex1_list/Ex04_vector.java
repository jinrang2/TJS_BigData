package com.lec.ex1_list;

import java.util.Vector;

public class Ex04_vector {
	public static void main(String[] args) {
		//Vector<GeneClass> veca = new Vector<AClass>();
		//Vector<GeneClass> vecb= new Vector<BClass>();
		
		Vector<GeneClass> vec = new Vector<GeneClass>();
		
		AClass objA = new AClass();
		BClass objB = new BClass();
		
		vec.add(objA);
		vec.add(objB);
		
		System.out.println(vec);
		
		for(int i=0 ; i<vec.size(); i++) {
			System.out.println(vec.get(i));
		}
		
		if(vec.isEmpty()) {
			System.out.println("vec에 데이터가 없습니다");
		} else {
			System.out.println("vec에 데이터가 있습니다");
		}
		
		//vec.add("C");
		//vec.add(10);
		
		
				
		
		
	}
}
