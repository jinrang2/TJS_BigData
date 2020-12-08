/**
 * 
 */
package com.lec.ex05shape;

/**
 * @author 정명곤
 * @date 2020. 12. 8.
 * 
 */
public class Circle extends Shape {

	private int r;
	public Circle() {}
	public Circle(int r) {
		this.r = r;
	}
	
	@Override
	public double computeArea() {
		//System.out.printf("원의 넓이는 %.2f\n" , Math.PI*r*r );
		return Math.PI*r*r;
	}
		
	@Override
	public void draw() {
		System.out.println("원 ");
		super.draw();
	}
	
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
}
