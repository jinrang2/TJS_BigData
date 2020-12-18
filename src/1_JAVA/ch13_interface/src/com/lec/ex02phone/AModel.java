/**
 * 
 */
package com.lec.ex02phone;

/**
 * @author 정명곤
 * @date 2020. 12. 9.
 * 인터페이스 구현 클래스 실습
 */
public class AModel implements IAcor {
	private String modelName;
	
	public AModel() {
		this.modelName = "A모델";
	}

	@Override
	public void dmbReceive() {
		System.out.println(modelName+"은 DMB 송수신 불가");

	}

	@Override
	public void lte() {
		System.out.println(modelName+"은 5G");

	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName+"은 TV리모콘 미탑재");

	}

}
