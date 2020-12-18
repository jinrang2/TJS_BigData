/**
 * 
 */
package com.lec.ex02;

/**
 * @author 정명곤
 * @date 2020. 12. 8.
 * 추상 클래스의 자식 클래스
 */
public class Child extends Super {

	@Override
	public void method1() {
		System.out.println("Child의 method1() - 추상메소드라 꼭 오버라이드");
	}
	
	public void method3() {
		System.out.println("Child의 method3() - 추상메소드가 아님");
	}
}
