package com.mine.store;
// 본사 지침         : 김치찌개-5,000  부대찌개-6,000  비빔밥-6,000 순대국-5,000  공기밥-1,000원
public abstract class HeadQuarterStore implements IStore {
	private String name;
	/*private int kimchi;
	private int bude;
	private int bibib;
	private int sunde;
	private int gonggibab;*/

	public HeadQuarterStore(String name) {
		super();
		this.name = name;
	}
	
	public abstract void kimchi();	
	public abstract void bude();	
	public abstract void bibib();	
	public abstract void sunde();	
	public abstract void gonggibab();
	
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
