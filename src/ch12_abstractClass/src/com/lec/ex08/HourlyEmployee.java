/**
 * 
 */
package com.lec.ex08;

/**
 * @author 정명곤
 * @date 2020. 12. 8.
 */
public class HourlyEmployee extends Employee {
	private int hoursWorked;
	private int moneyPerHour;

	public HourlyEmployee(String name , int hoursWorked, int moneyPerHour) {
		super(name);
		this.hoursWorked = hoursWorked;
		this.moneyPerHour = moneyPerHour;
	}
	
	@Override
	public int computePay() {
		return hoursWorked * moneyPerHour;
	}
	
	
}
