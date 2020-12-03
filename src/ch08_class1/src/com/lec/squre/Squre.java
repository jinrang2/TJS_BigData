package com.lec.squre;

public class Squre {
	private int side;

	public Squre() {
		System.out.println("매개변수 없는 생성자 호출됨");
	}

	public Squre(int side) {
		this.side = side;
		System.out.println("매개변수 있는 생성자 호출됨");
	}

	public int area() {
		return side * side;
	}
//

	public int	getSide() 			{		return side;		}
	public void	setSide(int side)	{		this.side = side;	}
}
