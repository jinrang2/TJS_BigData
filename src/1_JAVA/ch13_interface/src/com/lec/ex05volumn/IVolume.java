package com.lec.ex05volumn;

public interface IVolume {
	
	public void volumnUp();
	public void volumnUp(int level);
	public void volumnDown();
	public void volumnDown(int level);
	
	public void printInfo();
	
	public default void mute() {
		System.out.println("무음처리 합니다");
	}
}