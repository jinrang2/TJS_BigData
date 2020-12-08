/**
 * 
 */
package com.lec.ex07car;

import com.lec.cons.CarSpec;

/**
 * @author 정명곤
 * @date 2020. 12. 8.
 */
public class TestMain {
	public static void main(String[] args) {
		LowGradeCar lowCar = new LowGradeCar(CarSpec.GRAY_CAR, 
											CarSpec.TIRE_NORMAL, 
											CarSpec.DISPLACEMENT_1000, 
											CarSpec.HANDEL_POWER);
		
		HighGradeCar highCar = new HighGradeCar(CarSpec.GRAY_CAR, 
											CarSpec.TIRE_NORMAL, 
											CarSpec.DISPLACEMENT_1000, 
											CarSpec.HANDEL_POWER);
		
		lowCar.getSpec();
		
		highCar.getSpec();
	}
}
