package com.lec.man;
// Man kim = new Man();
public class Man {
	
	private	int		age;
	private int		height;
	private int		weight;
	private String	tel;
	
	public	Man()	{}
	
	public	Man(int age, int height, int weight, String tel) {
		this.age	= age;
		this.height = height;
		this.weight = weight;
		this.tel	= tel;
	}
	
	public	Man(int age, String tel) {
		this.age	= age;
		this.tel	= tel;
	}
	
	public	Man(int age, int height, int weight) {
		this.age	= age;
		this.height = height;
		this.weight = weight;
	}
	
	// BMI 지수를 반환하는 메소드
	public double calculateBMI() {
		return weight / ((height*0.01)*(height*0.01));
	}

	public int		getAge()		{		return age;		}
	public int		getHeight()		{		return height;	}
	public int		getWeight()		{		return weight;	}
	public String	getTel()		{		return tel;		}

	public void		setAge(int age) 		{	this.age = age;			}
	public void		setHeight(int height)	{	this.height = height;	}
	public void		setWeight(int weight)	{	this.weight = weight;	}
	public void		setTel(String tel)		{	this.tel = tel;			}
	
	
}
