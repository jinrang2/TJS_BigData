/**
 * 
 */
package com.lec.ex08;

/**
 * @author 정명곤
 * @date 2020. 12. 8.
 */
public class TestMain {
	public static void main(String[] args) {
		Employee[] employees = { new SalaryEmployee("홍길동", 18000000),
								new SalaryEmployee("박길동", 28000000),
								new SalaryEmployee("최길동", 38000000),
								new HourlyEmployee("이길동", 100, 18500),
								new HourlyEmployee("김길동", 100, 28500),
							};
		
		
		for (Employee e : employees) {
			Employee.printPay(e);
		}		
	}
}
