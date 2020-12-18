/**
 * 
 */
package com.lec.ex08;

/**
 * @author 정명곤
 * @date 2020. 12. 8.
 */
public class SalaryEmployee extends Employee {
	private int annalSalary;

	public SalaryEmployee(String name , int annalSalary) {
		super(name);
		this.annalSalary = annalSalary;
	}
	
	@Override
	public int computePay() {
		return annalSalary / 14;
	}
	
	
}
