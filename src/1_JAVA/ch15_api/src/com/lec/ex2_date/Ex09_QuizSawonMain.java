package com.lec.ex2_date;

public class Ex09_QuizSawonMain {
	public static void main(String[] args) {
		Sawon[] ss = {new Sawon("a01","홍길동", PartType.COMPUTER ),
					  new Sawon("a02","김길동", PartType.DESIGN, 2020,12 ,10 ),
					  new Sawon("a03","박길동", PartType.ACCOUNTING ),
					  new Sawon("a04","이길동", PartType.HUMANRESOURCE, 2020,12 ,11 ),
					  new Sawon("a03","최길동", PartType.PLANNING, 2020,12 ,13 )};
		
		for (Sawon s : ss ) {
			System.out.println(s);
		}
	}
}
