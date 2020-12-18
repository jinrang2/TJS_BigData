package com.lec.ex01store;

public class StoreNum3 implements HeadQuarterStore {
	private String name;
	/*private int kimchi;
	private int bude;
	private int bibib;
	private int sunde;
	private int gonggibab;*/
	
	
	public StoreNum3(String name) {
		this.name = name;
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

	@Override
	public void gonggibab() {
		System.out.println("공기밥 1,000원");
		
	}
	
	public String getName() {
		return name;
	}

	
	public void menuAll() {
		kimchi();
		bude();
		bibib();
		sunde();
		gonggibab();		
	}
}
