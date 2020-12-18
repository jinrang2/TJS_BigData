package com.lec.ex07_super;

public class ChildClass extends ParentClass  {
	private String cStr = "자식클래스";
	
	public ChildClass(int i) {
		super(i);
		System.out.println("C의 매개변수 있는 생성자");
	}
	
	public ChildClass() {
		System.out.println("C의 매개변수 없는 생성자");		
	}
	
	@Override
	public void getMamiName() {
		System.out.print("이쁜 아주 이쁜 ");				
		super.getMamiName();		
	}

	public String getcStr() {
		return cStr;
	}

	public void setcStr(String cStr) {
		this.cStr = cStr;
	}
}
