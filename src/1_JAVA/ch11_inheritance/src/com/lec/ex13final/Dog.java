/**
 * 
 */
package com.lec.ex13final;

/**
 * @author tjoeun
 *
 */
public final class Dog extends Animal {
	
	@Override
	public void running() {
		speed += 10;
		System.out.println("강아지가 뛰면서 꼬리를 흔들어요. 현속도:"+speed);
	}

	public void method( ) {
		System.out.println("method()");
	}
}
