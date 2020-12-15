package com.lec.ex4_Object;

public class Rectangle {
	private int x;
	private int y;
	private String color;
	
	public Rectangle() {
		color = "검정";
	}

	public Rectangle(int x, int y, String color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	@Override
	public String toString() {
		return String.format("[가로 %2dcm,  세로 %2dcm의 %s색 사각형]", x,y,color);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)	{
			return true;
		}
		
		if (obj == null)	{
			System.out.print("null 체크 ");
			return false;
		}
		
		if ((obj instanceof Rectangle) == false)		{
			System.out.print("타입 체크 ");
			return false;
		}
		
		Rectangle temp = (Rectangle)obj;
		
		if (x != temp.x) {
			System.out.print("x값 체크 ");
			return false;
		}
		if (y != temp.y) {
			System.out.print("y값 체크 ");
			return false;
		}
		
		if (color.equals(temp.color) == false)	{
			System.out.print("색상 체크 ");
			return false;
		}
		
		return true;
	}
	
	
	
	
}
