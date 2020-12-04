package com.lec.ex3_accessTest;

public class AccessTest {
	private int		privateMember;
	int 			defaultMember;				// 디퐅트 같은 패지키니 내에서만
	protected int	protectedMember;  // 같은 패키지나 상속받은 하위 클래스
	public int 		publicMember;
	
	private void 	privateMethod() {
		System.out.println("private 메소드 호출");
	}
	
	void 			defaultMethod()	{
		System.out.println("private 메소드 호출");
	}			// 디퐅트 같은 패지키니 내에서만
	
	protected void 	protectedMethod() {
		System.out.println("protected 메소드 호출");
	} // 같은 패키지나 상속받은 하위 클래스
	
	public void 	publicMethod() {
		System.out.println("public 메소드 호출");
	}
	
}