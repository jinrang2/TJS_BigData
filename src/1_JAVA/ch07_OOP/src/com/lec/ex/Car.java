package com.lec.ex;

// Car myPorche =  new Car();
// Scanner sc = new Scanner();

public class Car {
	private String	color;
	private int		cc;
	private int		speed;
	public Car() {
		// 디폴트 생성자 함수
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
		System.out.println("운전한다 지금 속도 : "+speed);
	}
	
	public void park() {
		speed = 0;
		System.out.println("주차한다 지금 속도 : "+speed);
	}
	
	public void race() {
		speed = 120;
		System.out.println("주차한다 지금 속도 : "+speed);
	}
	
}
