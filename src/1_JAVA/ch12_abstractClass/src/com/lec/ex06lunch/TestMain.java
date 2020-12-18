/**
 * 
 */
package com.lec.ex06lunch;

import com.lec.cons.PriceTable;

/**
 * @author 정명곤
 * @date 2020. 12. 8.
 */
public class TestMain {

	public static void main(String[] args) {
		LunchMenu c1 = new Child1(PriceTable.RICE,
								PriceTable.BULGOGI,
								PriceTable.SOUP,
								PriceTable.BANANA,
								PriceTable.MILK,
								PriceTable.ALMOND);
		LunchMenu c2 = new Child2(PriceTable.RICE,
								PriceTable.BULGOGI,
								PriceTable.SOUP,
								PriceTable.BANANA,
								PriceTable.MILK,
								PriceTable.ALMOND);
		
		System.out.println("child1형 식대 : "+ c1.calculate());
		System.out.println("child2형 식대 : "+ c2.calculate());
		

	}

}
