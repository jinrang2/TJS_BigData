package com.mine.store;

public class StoreMain {
	public static void main(String[] args) {
		//HeadQuarterStore st = new HeadQuarterStore("===본  사===");
		IStore st1 = new StoreNum1("===1호점===");
		IStore st2 = new StoreNum2("===2호점===");
		IStore st3 = new StoreNum3("===3호점===");
		
//		System.out.println(st.getName());
//		st.menuAll();
		
		
		System.out.println(st1.getName());
		st1.menuAll();
		
		
		System.out.println(st2.getName());
		st2.menuAll();
		
		
		System.out.println(st3.getName());
		st3.menuAll();	
		 
	}
}
