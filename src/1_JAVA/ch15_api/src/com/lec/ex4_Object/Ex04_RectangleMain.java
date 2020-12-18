package com.lec.ex4_Object;

public class Ex04_RectangleMain {

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle(10,20,"빨강");
		Rectangle r3 = new Rectangle(10,20,"빨빨강");
		Rectangle r4 = new Rectangle(10,10,"빨강");
		Rectangle r5 = new Rectangle(10,20,"빨강");
		
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r4);
		System.out.println(r5);
		
		recDiff(r1,r2);
		recDiff(r2,r3);
		recDiff(r2,r4);
		recDiff(r2,r5);
	}
	
	public static void recDiff(Rectangle a, Rectangle b) {
		if (a.equals(b))	{
			System.out.println("같음");
		} else {
			System.out.println("틀림");
		}
	}

}
