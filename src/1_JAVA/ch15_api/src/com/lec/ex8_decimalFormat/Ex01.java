package com.lec.ex8_decimalFormat;

import java.text.DecimalFormat;
// 숮자 자리에 : #(있으면 출력 없으면 출력 안함) 0(반드시 출력) 
// , %, E
public class Ex01 {
	public static void main(String[] args) {
		
		String[] patterns = {"00000000.00000","########.#####","#,###.00000","%000000000000.#","#.#######E0"};
		
		double number = 1234567.8889;
		//DecimalFormat df1 = new DecimalFormat("");
		DecimalFormat df2 = new DecimalFormat("00000000.00000");
		DecimalFormat df3 = new DecimalFormat("########.#####");
		DecimalFormat df4 = new DecimalFormat("#,###.00000");
		DecimalFormat df5 = new DecimalFormat("%000000000000.#");
		DecimalFormat df6 = new DecimalFormat("#.#######E0");
		
		for (String string : patterns) {
			DecimalFormat name = new DecimalFormat(string);
			System.out.println(name.format(number));
		}
		
		//System.out.println(df1.format(number));
		/*System.out.println(df2.format(number));
		System.out.println(df3.format(number));
		System.out.println(df4.format(number));
		System.out.println(df5.format(number));
		System.out.println(df6.format(number));*/
		
		
	}
}
