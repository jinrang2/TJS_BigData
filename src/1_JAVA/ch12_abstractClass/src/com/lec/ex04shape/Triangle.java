/**
 * 
 */
package com.lec.ex04shape;

/**
 * @author 정명곤
 * @date 2020. 12. 8.
 */
public class Triangle extends Shape {
	private int w;		// 밑변
	private int h;		// 넓이
	
	public Triangle() {
		
	}

	public Triangle(int w, int h) {
		this.w = w;
		this.h = h;
	}

	@Override
	public void computeArea() {
		System.out.println("삼각형의 넓이는 " + w*h/2 );
	}
	
	@Override
	public void draw() {
		System.out.println("삼각형");
		super.draw();
	}

}
