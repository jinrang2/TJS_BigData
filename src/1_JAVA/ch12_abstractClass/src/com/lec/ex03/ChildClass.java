/**
 * 
 */
package com.lec.ex03;

/**
 * @author 정명곤
 * @date 2020. 12. 8.
 * 추상클래스를 상속받은 자식 클래스를 추상 클래스로 선언시 부모의 추상메서드가 생략되어 있음
 */
public abstract class ChildClass extends SuperClass {
	
	@Override
	public void method2() {
		System.out.println("ChildeClass의 method2() (오버라이드)");
	}

	public void method3() {
		System.out.println("ChildeClass의 method2() (자신만 있는 메서드)");
	}
}
