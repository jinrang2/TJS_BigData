/**
 * 
 */
package com.lec.ex08;

import java.text.DecimalFormat;

/**
 * @author 정명곤
 * @date 2020. 12. 8.
 */
public abstract class Employee {
	private String name;

	public Employee(String name) {
		this.name = name;
	}
	
	public abstract int computePay();

	public final double computeIncentive() {
		int pay = computePay();
		
		return pay >= 2000000 ? pay*0.1 : 0; 
	}
	
	public static void printPay(Employee e) {
		System.out.println("==========급여 명세서==========");
		System.out.println("이  름 : " + e.getName());
		System.out.println("급  여 : " + e.currency(e.computePay()));
				
		if( e.computeIncentive() > 0) {
			System.out.printf("상여금 : %s\n" , e.currency(e.computeIncentive()));
			System.out.println("-------------------------------");
			System.out.printf("총급여 : %s\n" , e.currency(e.computePay()+e.computeIncentive()));
		}
		
		System.out.println("===============================");
		System.out.println();
	}
	
	private String currency(double pay) {
		return new DecimalFormat("#,###").format(pay);
	}
	

	public String getName() {
		return name;
	}
}
