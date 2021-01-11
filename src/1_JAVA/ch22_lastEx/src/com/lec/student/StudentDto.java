package com.lec.student;

public class StudentDto {
	private String 	sno;
	private String	sname;
	private String	mname;
	private int		score;
	private int 	sexpel;
	
	private String 	rank;
	private String	nameno;
	
	
	public StudentDto(String sno, String sname, String mname, int score, int sexpel) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.mname = mname;
		this.score = score;
		this.sexpel = sexpel;
	}
		
	public StudentDto(String rank, String nameno, String mname, int score) {
		super();
		this.rank = rank;
		this.nameno = nameno;
		this.mname = mname;
		this.score = score;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getNameno() {
		return nameno;
	}

	public void setNameno(String nameno) {
		this.nameno = nameno;
	}

	public String toString() {
		return "StudentDto [sno=" + sno + ", sname=" + sname + 
				", mname=" + mname + ", score=" + score + ", sexpel=";				
	}

	public String getSno() {
		return sno;
	}

	public String getSname() {
		return sname;
	}

	public String getMname() {
		return mname;
	}

	
	public int getScore() {
		return score;
	}
	
	public int getSexpel() {
		return sexpel;
	}	
}
