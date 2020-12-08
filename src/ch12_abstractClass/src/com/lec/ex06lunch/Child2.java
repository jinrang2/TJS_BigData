/**
 * 
 */
package com.lec.ex06lunch;

/**
 * @author 정명곤
 * @date 2020. 12. 8.
 */
public class Child2 extends LunchMenu {
	
	public Child2(int rice, int bulgogi, int soup, int banana, int milk, int almond) {
		super(rice, bulgogi, soup, banana, milk, almond);
	}

	public int calculate() {		
		return getRice()+getBulgogi()+getSoup()+getMilk();
	}
}
