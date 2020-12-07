package com.lec.ex11store;

public class StoreMain {
	public static void main(String[] args) {
		HeadQuarterStore st = new HeadQuarterStore("===본  사===");
		System.out.println(st.getName());
		st.menuAll();
		
		HeadQuarterStore st1 = new HeadQuarterStore("===1호점===");
		System.out.println(st.getName());
		st1.menuAll();
		
		HeadQuarterStore st2 = new HeadQuarterStore("===2호점===");
		System.out.println(st2.getName());
		st2.menuAll();
		
		HeadQuarterStore st3 = new HeadQuarterStore("===3호점===");
		System.out.println(st3.getName());
		st3.menuAll(); 
		
		StoreBuilder stBuilder = new StoreBuilder("===4호점===");
		HeadQuarterStore rst = stBuilder
				.kimchi(4000)
				.bude(4000)
				.bibib(4000)
				.sunde(4000)
				.gonggibab(0)
				.build();
		
	}
}
