package com.mine.store;

public class StoreNum1 extends HeadQuarterStore {
	public StoreNum1(String name) {
		super(name);
	}
	
	@Override
	public void kimchi() {
		System.out.println("김치찌개 : 4,500d원");
	}
		
	@Override
	public void bude() {
		System.out.println("부대찌개 : 5,000d원");
	}
	
	@Override
	public void bibib() {
		System.out.println("비빔밥 : 5,000");
		
	}
	
	@Override
	public void sunde() {
		System.out.println("순대국 : 안팔아");
	}



	@Override
	public void gonggibab() {
		System.out.println("순대국 : 안팔아");
		
	}

	public void menuAll() {
		kimchi();
		bude();
		bibib();
		sunde();
		gonggibab();		
	}


}
