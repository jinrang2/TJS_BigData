package com.lec.ex01store;

public class StoreNum2 implements HeadQuarterStore {
	private String name;
	/*private int kimchi;
	private int bude;
	private int bibib;
	private int sunde;
	private int gonggibab;*/
	
	public StoreNum2(String name) {
		this.name = name;
	}
	
	@Override
	public void kimchi() {
		System.out.println("김치찌개 : 5,000원");
		
	}
	
	@Override
	public void bude() {
		System.out.println("부대찌개 : 5,000원");
	}
	@Override
	public void bibib() {
		System.out.println("비빔밥 : 5,000원");
	}
	
	@Override
	public void sunde() {
		System.out.println("순대국 : 5,000원");		
	}
	
	@Override
	public void gonggibab() {
		System.out.println("공기밥 : 무료");
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
