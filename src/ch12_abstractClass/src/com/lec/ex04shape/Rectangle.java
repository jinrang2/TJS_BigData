/**
 * 
 */
package com.lec.ex04shape;

/**
 * @author 정명곤
 * @date 2020. 12. 8.
 */
public class Rectangle extends Shape {

	private int w;
	private int h;
	
	public Rectangle() {}
	
	public Rectangle(int w, int h){
		this.w = w;
		this.h = h;
	}
	
	@Override
	public void computeArea() {
		System.out.println("사각형의 넓이는 " + w*h );
	}
	
	@Override
	public void draw() {
		System.out.println("사각형");
		super.draw();
	}
}
