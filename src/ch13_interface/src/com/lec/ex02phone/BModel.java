/**
 * 
 */
package com.lec.ex02phone;

/**
 * @author 정명곤
 * @date 2020. 12. 9.
 * 인터페이스 구현 클래스 실습
 */
public class BModel implements IAcor {
	private String modelName;
	
	public BModel() {
		this.modelName = "B모델";
	}

	@Override
	public void dmbReceive() {
		System.out.println(modelName+"은 DMB 송수신 불가");

	}

	@Override
	public void lte() {
		System.out.println(modelName+"은 LTE");

	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName+"은 TV리모콘 탑재");

	}

}
