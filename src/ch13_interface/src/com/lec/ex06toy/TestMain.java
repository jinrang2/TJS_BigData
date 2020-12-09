/**
 * 
 */
package com.lec.ex06toy;

/**
 * @author 정명곤
 * @date 2020. 12. 9.
 */
public class TestMain {

	public static void main(String[] args) {
		IToy[] toy = { new Pooh(),
						new MazingerToy(),
						new AirPlaneToy()
		};
		
		for(IToy t : toy) {
			System.out.println(t.getClass());
			System.out.println(t.toString());
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
			
		}
	}

}
