/**
 * 
 */
package com.lec.ex03;

import com.lec.ex02.Child;

/**
 * @author 정명곤
 * @date 2020. 12. 8.
 * 추상 클래스를 상속받은 추상 클래스를 다시 상속 받은 경우
 */
public class GrandChildClass extends ChildClass {
	@Override
	public void method1() {
		System.out.println("GrandChild의 method1()");
	}
	
	
}
