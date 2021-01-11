package com.lec.person_dao;

public class PersonDto {
	private int rank;
	private String name;
	private String jname;
	private int kor;
	private int eng;
	private int mat;	
	private int sum;
	
	
	
	public PersonDto(int rank, String name, String jname, int kor, int eng, int mat, int sum) {
		super();
		this.rank = rank;
		this.name = name;
		this.jname = jname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.sum = sum;
	}
	
	public PersonDto(String name, String jname, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.jname = jname;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}


	@Override
	public String toString() {
		return "PersonDto [rank=" + rank + ", name=" + name + ", jname=" + jname + ", kor=" + kor + ", eng=" + eng
				+ ", mat=" + mat + ", sum=" + sum + "]";
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
	
}
