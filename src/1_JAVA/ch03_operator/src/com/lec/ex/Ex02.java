package com.lec.ex;
// 증감연산자 (++, --)
public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1 = 10;
		int n2 = n1++;
		
		
		System.out.printf("1. n1=%d, n2=%d\n",n1,n2);		
		//System.out.println(n2);
		
		
		int n3 = 10;
				
		
		System.out.printf("2. n3=%d\n",n3--);
		System.out.printf("3. n3=%d\n",n3);
		//System.out.println(n2);
		
		int temp = 10;
		
		System.out.printf("4. %d %d %d %d %d\n",temp++, ++temp, temp--, temp--, temp);
		
	}
	

}
