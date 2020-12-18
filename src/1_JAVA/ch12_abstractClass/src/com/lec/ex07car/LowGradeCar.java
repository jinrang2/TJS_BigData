/**
 * 
 */
package com.lec.ex07car;

/**
 * @author 정명곤
 * @date 2020. 12. 8.
 */
public class LowGradeCar extends Car {
	private int tax = 50000;
	/**
	 * @param color
	 * @param tire
	 * @param displacement
	 * @param handle
	 */
	public LowGradeCar(String color, String tire, int displacement, String handle) {
		super(color, tire, displacement, handle);
	}

	@Override
	public void getSpec() {
		if (getDisplacement() > 1000) {
			tax += (getDisplacement()-1000)*100;
		}
		
		System.out.println();
		System.out.println("*****************************************************************");
		System.out.println("색  상 : "+ getColor());
		System.out.println("타이어 : "+ getTire());
		System.out.println("배기량 : "+ getDisplacement());
		System.out.println("핸  들 : "+ getHandle());
		System.out.println("세  금 : "+ tax);
		System.out.println("*****************************************************************");
	}

	@Override
	public int getTax() {
		
		return 0;
	}

}
