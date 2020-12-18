package com.lec.ex11store;

public class StoreBuilder {
	private String storeName;
	
	private int kimchi;
	private int bude;
	private int bibib;
	private int sunde;
	private int gonggibab;

	
	public StoreBuilder(String storeName) {
		this.storeName = storeName;
	}
	
	public StoreBuilder kimchi(int val) {
		kimchi = val;
		return this;
	}
	
	public StoreBuilder bude(int val) {
		bude = val;
		return this;
	}
	
	public StoreBuilder bibib(int val) {
		bibib = val;
		return this;
	}
	
	public StoreBuilder sunde(int val) {
		sunde = val;
		return this;
	}
	
	public StoreBuilder gonggibab(int val) {
		gonggibab = val;
		return this;
	}
	
	public HeadQuarterStore build() {
		HeadQuarterStore hqst = new HeadQuarterStore(storeName);
		return hqst;
	}
	
	
}
