package com.lec.ex;
// 관계(비교)연산자 
public class Ex03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n1=10, n2=5;
		boolean  result = n1 > n2;
		
		result = n1 >  n2;		System.out.printf("%d %s %d = %b\n", n1,"> ",n2,result);
		result = n1 >= n2;		System.out.printf("%d %s %d = %b\n", n1,">=",n2,result);
		result = n1 <  n2;		System.out.printf("%d %s %d = %b\n", n1,"< ",n2,result);
		result = n1 <= n2;		System.out.printf("%d %s %d = %b\n", n1,"<=",n2,result);
		result = n1 == n2;		System.out.printf("%d %s %d = %b\n", n1,"==",n2,result);
		result = n1 != n2;		System.out.printf("%d %s %d = %b\n", n1,"!=",n2,result);
	}

}
