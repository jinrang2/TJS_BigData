package com.lec.man;

public class ManMain {
	
	public static void main(String[] args) {
		
		Man kim = new Man(20,170,60,"010-999-9999");
		//Man yi= new Man(20,170,60);
		Man kang = new Man(20,"010-999-9999");
		
		Man[] student = {kim, kang};
		//yi.setTel("010-8888-8888");
		
		kang.setWeight(180);
		kang.setWeight(65);
		
		
		
		double biman = kim.calculateBMI();
		
		System.out.println(biman > 24 ? "Kim은 비만이니 건강조심" : "kim은 다이어트 금지");
	
		/*biman = yi.calculateBMI();
		System.out.println(biman > 24 ? "건강조심 다이어트" : "다이어트 금지");*/
		
		biman = kang.calculateBMI();
		System.out.println(biman > 24 ? "건강조심 다이어트" : "다이어트 금지");
		
		System.out.println(System.identityHashCode(kim) );
		System.out.println(kim);
		System.out.println(System.identityHashCode(student[0]) );
		System.out.println(student[0]);
		
		
		System.out.println(kang);
		System.out.println(System.identityHashCode(kang) );
		System.out.println(student[1]);
		System.out.println(System.identityHashCode(student[1]) );
	}
}
