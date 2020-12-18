package com.lec.ex11store;

public class StoreNum3 extends HeadQuarterStore {
	public StoreNum3(String name) {
		super(name);
	}
		
	@Override
	public void kimchi() {
		System.out.println("김치찌개 6,000원");
	}
	
	@Override
	public void bude() {
		System.out.println("부대찌개 7,000원");
	}
	
	@Override
	public void bibib() {
		System.out.println("비빔밥 7,000원");
	}
	
	@Override
	public void sunde() {
		System.out.println("순대국 6,000원");
	}
}
