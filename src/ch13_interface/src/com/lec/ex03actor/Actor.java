/**
 * 
 */
package com.lec.ex03actor;

/**
 * @author 정명곤
 * @date 2020. 12. 9.
 * 3개의 인터페이스를 받는 배우 클래스
 */
public class Actor implements Chef, FireFighter, PoliceMan {
	private String name;
	
	public Actor (String name) {
		this.name = name;
	}
	
	@Override
	public void catCatchCriminal() {
		System.out.println(name+"은 범인을 잡는다");

	}

	@Override
	public void canSearch() {
		System.out.println(name+"은 물건을 찾을 수 있다");

	}

	@Override
	public void makePizza() {
		System.out.println(name+"은 피자를 만들 수 있다");

	}

	@Override
	public void makeSpaghetti() {
		System.out.println(name+"은 스파게티를 만들 수 있다");

	}

	@Override
	public void outFire() {
		System.out.println(name+"은 불을 끌 수 있다");

	}

	@Override
	public void saveMan() {
		System.out.println(name+"은 사람을 구할 수 있다");

	}

}
