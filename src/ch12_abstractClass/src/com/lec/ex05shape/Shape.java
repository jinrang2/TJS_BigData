/**
 * 
 */
package com.lec.ex05shape;

/**
 * @author 정명곤
 * @date 2020. 12. 8.
 * 추상 클래스 예제
 */
public abstract class Shape {
	public void draw() {
		System.out.println("도형을 그려요");		
	}
	
	public abstract double computeArea();
	
}
