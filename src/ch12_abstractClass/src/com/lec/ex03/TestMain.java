/**
 * 
 */
package com.lec.ex03;

/**
 * @author 정명곤
 * @date 2020. 12. 8.
 * 추상 클래스 상속 유형에 따른 추상메서드 구현 및 선언과 new가능한 경우
 */
public class TestMain {
	public static void main(String[] args) {
		//SuperClass sup =  new SuperClass();
		//ChildClass child =  new ChildClass();
				
		SuperClass sup = new GrandChildClass();
		ChildClass child = new GrandChildClass();
		GrandChildClass grand=  new GrandChildClass();
	}
}
