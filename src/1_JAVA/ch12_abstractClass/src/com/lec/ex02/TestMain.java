/**
 * 
 */
package com.lec.ex02;

/**
 * @author 정명곤
 * @date 2020. 12. 8.
 * 추상 클래스와 하위 클래스의 메서드 사용 유형 
 */
public class TestMain {
	public static void main(String[] args) {
		Child c1 = new Child();
		
		c1.method1();
		c1.method2();
		c1.method3();
		
		Super c2 = new Child();
		
		c2.method1();
		c2.method2();
		//c2.method3();			// 상위 클래스에서는 하위 클래스에서만 구현한 메서드 실행 못함
	}
}
