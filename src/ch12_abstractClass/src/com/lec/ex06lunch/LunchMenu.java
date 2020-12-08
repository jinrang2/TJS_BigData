/**
 * 
 */
package com.lec.ex06lunch;

/**
 * @author 정명곤
 * @date 2020. 12. 8.
 * 추상 클래스 예제 1
 */
public abstract class LunchMenu {
	private int rice;			// 쌀 값
	private int bulgogi;		// 불고기 값
	private int soup;			// 국재료 값
	private int banana;			// 바나나 값
	private int milk;			// 우유값
	private int almond;			// 아몬드값
	
	public LunchMenu() {}

	public LunchMenu(int rice, int bulgogi, int soup, int banana, int milk, int almond) {
		this.rice = rice;
		this.bulgogi = bulgogi;
		this.soup = soup;
		this.banana = banana;
		this.milk = milk;
		this.almond = almond;
	}

	public abstract int calculate();
	
	
	public int getRice() {
		return rice;
	}

	public int getBulgogi() {
		return bulgogi;
	}

	public int getSoup() {
		return soup;
	}

	public int getBanana() {
		return banana;
	}

	public int getMilk() {
		return milk;
	}

	public int getAlmond() {
		return almond;
	}	
}