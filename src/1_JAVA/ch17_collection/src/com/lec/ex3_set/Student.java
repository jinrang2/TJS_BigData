package com.lec.ex3_set;

public class Student {
	private String name;
	private int grade;
	
	public Student() {name="";}
	
	public Student(String name, int grade) {
		this.name = name;
		this.grade = grade;
		
	}

	@Override
	public String toString() {
		return name + ":" + grade;
	}

	@Override
	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + grade;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
		
		return toString().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if(obj!=null && obj instanceof Student) {
			boolean nameChk = name.equals(((Student)obj).name);
			boolean gradeChk = grade == ((Student)obj).grade;
			return nameChk && gradeChk;
		}


		return true;
	}
	
	
}
