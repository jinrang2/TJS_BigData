package com.lec.squre;

public class Squre {
	private int side;

	public Squre() {
		System.out.println("�Ű����� ���� ������ ȣ���");
	}

	public Squre(int side) {
		this.side = side;
		System.out.println("�Ű����� �ִ� ������ ȣ���");
	}

	public int area() {
		return side * side;
	}
//

	public int	getSide() 			{		return side;		}
	public void	setSide(int side)	{		this.side = side;	}
}
