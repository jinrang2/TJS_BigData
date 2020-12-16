package com.lec.ex3_exceptionExs;

public class Ex03_numberFormat {
	public static void main(String[] args) {
		String str =  "10000 ";
		int i = Integer.parseInt(str.trim());
		
		System.out.println(i);
		
		String str2 =  " ";
		int j = 0;
		try {
			j = Integer.parseInt(str2.trim());
		} catch (NumberFormatException e) {
			//System.out.println(e.toString());
			System.out.println(e.getMessage());
			//e.printStackTrace();
			j=0;
		}
		
		System.out.println(j);
	}
}
