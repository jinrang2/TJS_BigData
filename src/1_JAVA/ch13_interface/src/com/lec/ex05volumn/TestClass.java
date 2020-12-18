package com.lec.ex05volumn;

public class TestClass {
	public static void main(String[] args) {
		IVolume tv = new TvClass();
		
		tv.volumnUp();
		tv.volumnUp(5);
		tv.volumnUp(5);
		tv.volumnDown();
		tv.volumnDown(5);
		tv.volumnDown(5);
		
		System.out.println();
		
		IVolume ra = new RadioClass();
		
		ra.volumnUp();
		ra.volumnUp(5);
		ra.volumnUp(5);
		ra.volumnUp(5);
		ra.volumnUp(5);
		ra.volumnDown();
		ra.volumnDown(5);
		ra.volumnDown(5);
		ra.volumnDown(5);
		ra.volumnDown(5);
		
	}
}
