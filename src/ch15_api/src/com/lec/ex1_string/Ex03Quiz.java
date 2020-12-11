package com.lec.ex1_string;

import java.util.Scanner;

public class Ex03Quiz {

	public static void main(String[] args) {
		String tel="";
		int i = 0;
		
		
		Scanner sc = new Scanner(System.in);
		
		while( !tel.toLowerCase().equals("x")) {
			tel = sc.next();
			
			
			tel = "031-234-5678";
			int len = tel.length();
			
			System.out.println(tel);
			
			for (i=0; i < len; i += 2) {
				System.out.print(tel.charAt(i));
			}
			System.out.println();
			
		for (i=len ; i > 0 ; --i) {
				System.out.print(tel.charAt(i-1));
			}
			System.out.println();
			
			System.out.println(tel.substring(0,tel.indexOf('-')));
			System.out.println(tel.substring(tel.lastIndexOf('-')+1,len));
			
			
		}
				
				
				
		
		
	}

}
