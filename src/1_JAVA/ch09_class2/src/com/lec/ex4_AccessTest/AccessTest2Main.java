package com.lec.ex4_AccessTest;

import com.lec.ex3_accessTest.AccessTest;

public class AccessTest2Main {
	
	public static void main(String[] args) {
		AccessTest obj = new AccessTest();
		
		//System.out.println(obj.privateMember);
		//System.out.println(obj.defaultMember);
		//System.out.println(obj.protectedMember);
		System.out.println(obj.publicMember);
		
		//obj.privateMethod();
		//obj.defaultMethod();
		//obj.protectedMethod();
		obj.publicMethod();		
	}
}
