package com.lec.ex01store;
// 본사 지침         : 김치찌개-5,000  부대찌개-6,000  비빔밥-6,000 순대국-5,000  공기밥-1,000원
public interface HeadQuarterStore {
	
	public void kimchi();	
	public void bude();	
	public void bibib();	
	public void sunde();	
	public void gonggibab();
	public void menuAll();
	
	public String getName();
}
