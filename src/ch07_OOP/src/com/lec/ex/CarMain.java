package com.lec.ex;

import java.util.Scanner;

public class CarMain {
	public static void main(String[] args) {
		
		Scanner sc	 	= new Scanner(System.in);
		Car myPorsche	= new Car();
		Car yourPorsche	= new Car();
		
		myPorsche.drive();
		yourPorsche.drive();
		myPorsche.park();
		myPorsche.race();
		
		myPorsche.setColor("red");
				
		System.out.println("�� ������ ���� : "+myPorsche.getColor());
		System.out.println("�츮�� ������ ���� : "+yourPorsche.getColor());
		System.out.println("�� ������ ���� : "+myPorsche);
		System.out.println("�츮�� ������ ���� : "+yourPorsche);
	}
}
