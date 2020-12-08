/**
 * 
 */
package com.lec.ex07car;

/**
 * @author 정명곤
 * @date 2020. 12. 8.
 */
public abstract class Car {
	private String color;			// 색상
	private String tire;			// 타이어
	private int displacement;		// 배기량
	private String handle;			// 핸들
	
	public Car(String color, String tire, int displacement, String handle) {
		this.color = color;
		this.tire = tire;
		this.displacement = displacement;
		this.handle = handle;
	}
	
	public abstract void getSpec();
	public abstract int  getTax();

	public String getColor() {
		return color;
	}

	public String getTire() {
		return tire;
	}

	public int getDisplacement() {
		return displacement;
	}

	public String getHandle() {
		return handle;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setTire(String tire) {
		this.tire = tire;
	}

	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}	
}
