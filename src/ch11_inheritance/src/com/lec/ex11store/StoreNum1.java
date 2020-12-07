package com.lec.ex11store;

public class StoreNum1 extends HeadQuarterStore {
	public StoreNum1(String name) {
		super(name);
	}
	
	
	@Override
	public void bude() {
		System.out.println("부대찌개 : 5,000d원");
	}
	@Override
	public void sunde() {
		System.out.println("순대국 : 안팔아");
	}
}
