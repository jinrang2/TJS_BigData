package com.lec.squre;

public class BoxOrRect {
	private int width;
	private int height;
	private int depth;
	private int volume;
	private char unit;
	
	public BoxOrRect() {}

	public BoxOrRect(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth != 0 ? depth : 1;
		this.unit = 'зи';
		this.calNsetVolume();		
	}
	
	public BoxOrRect(int width, int height) {
		this.width = width;
		this.height = height;
		this.unit = 'з▓';
		this.calNsetVolume();
	}
	
	public char getUnit() {
		return unit;
	}

	public void setUnit(char unit) {
		this.unit = unit;
	}
	
	public void calNsetVolume()	{
		volume = depth >0 ? width*height*depth : width*height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
		
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}	
	
	
}
