package com.lec.ex;

// Car myPorche =  new Car();
// Scanner sc = new Scanner();

public class Car {
	private String	color;
	private int		cc;
	private int		speed;
	public Car() {
		// ����Ʈ ������ �Լ�
		cc = 1000;
		
	}
	
	public String	getColor()			{	return color;		}
	public int		getCc() 			{	return cc;			}
	public int		getSpeed()			{	return speed;		}
	
	public void setColor(String color)	{	this.color = color;	}
	public void setCc(int cc) 			{	this.cc = cc;		}
	public void setSpeed(int speed) 	{	this.speed = speed;	}


	public void drive() {
		speed = 60;
		System.out.println("�����Ѵ� ���� �ӵ� : "+speed);
	}
	
	public void park() {
		speed = 0;
		System.out.println("�����Ѵ� ���� �ӵ� : "+speed);
	}
	
	public void race() {
		speed = 120;
		System.out.println("�����Ѵ� ���� �ӵ� : "+speed);
	}
	
}
