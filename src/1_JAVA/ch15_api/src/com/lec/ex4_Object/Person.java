package com.lec.ex4_Object;

public class Person {
	private long juminNo;
	
	public Person(long juminNo) {
		this.juminNo = juminNo;
	}
	
	
	public long getJuminNo() {
		return juminNo;
	}

	public void setJuminNo(long juminNo) {
		this.juminNo = juminNo;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		}  
		
		if (obj!=null && obj instanceof Person) {
			if(this.juminNo == ((Person) obj).juminNo) {
				return true;
			}            	
		}
		
		return false;  
	}
}
