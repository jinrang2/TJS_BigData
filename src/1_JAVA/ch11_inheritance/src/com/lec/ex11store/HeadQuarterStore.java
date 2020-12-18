package com.lec.ex11store;
// 본사 지침         : 김치찌개-5,000  부대찌개-6,000  비빔밥-6,000 순대국-5,000  공기밥-1,000원
public class HeadQuarterStore {
	private String name;
	private int kimchi;
	private int bude;
	private int bibib;
	private int sunde;
	private int gonggibab;

	public HeadQuarterStore(String name) {
		super();
		this.name = name;
	}
	
	public void kimchi() {
		System.out.println("김치찌개 5,000원");
	}
	
	public void bude() {
		System.out.println("부대찌개 5,000원");
	}
	
	public void bibib() {
		System.out.println("비빔밥 5,000원");
	}
	
	public void sunde() {
		System.out.println("순대국 5,000원");
	}
	
	public void gonggibab() {
		System.out.println("공기밥 1,000원");
	}
	
	public void menuAll() {
		kimchi();
		bude();
		bibib();
		sunde();
		gonggibab();		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}
