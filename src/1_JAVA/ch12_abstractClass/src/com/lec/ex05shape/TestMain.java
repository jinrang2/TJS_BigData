/**
 * 
 */
package com.lec.ex05shape;

/**
 * @author 정명곤
 * @date 2020. 12. 8.
 */
public class TestMain {
	public static void main(String[] args) {
		Shape[] shape = {new Circle(5), new Rectangle(10,5), new Triangle(5, 10)};
			
//		for (int i = 0; i <= shape.length; i++) {
//			shape[i].draw();
//			shape[i].computeArea();
//		}
		
		for (Shape s : shape) {
			System.out.println(s.computeArea()); 
			s.draw();
		}
	}
}
