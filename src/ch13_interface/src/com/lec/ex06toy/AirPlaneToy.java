/**
 * 
 */
package com.lec.ex06toy;

/**
 * @author 정명곤
 * @date 2020. 12. 9.
 */
public class AirPlaneToy implements IMissile, ILigth {
	
	public AirPlaneToy() {
		System.out.println("비행기 장난감입니다");
		canLight();
		canMissile();
		System.out.println("=========================");
	}

	@Override
	public void canLight() {
		System.out.println("비행기가 불빛을 쏩니다");
		
	}

	@Override
	public void canMissile() {
		System.out.println("비행기가 미사일을 쏩니다");
		
	}
	
	@Override
	public String toString() {
		return "미사일 빛 비행기";
	}
	
}
