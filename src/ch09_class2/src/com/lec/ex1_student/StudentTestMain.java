package com.lec.ex1_student;

public class StudentTestMain {
	public static void main(String[] args) {
		Student[] student = { new Student("정우성",90,80,95),
				  new Student("김하늘",100,80,95),
				  new Student("황정민",95,80,90),
				  new Student("강동원",95,90,99),
				  new Student("유아인",90,90,90)
		};
		
		Student.headerPrint();		
				
		for (Student p : student) {
			p.itemPrint();
		}
		
		Student.summaryPrint();
		Student.footerPrint();
		
		Character ch = new Character('c');
		System.out.println(ch);
	}				
}