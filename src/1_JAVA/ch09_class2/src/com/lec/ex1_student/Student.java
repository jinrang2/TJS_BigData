package com.lec.ex1_student;

public class Student {
	private String name;
	private int stNo;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double avg=0;
	
	private static int stCnt = 0;	
	private static double[] sumItems = new double[5];
	private static double[] avgItems = new double[5];
		
	public Student() {}
	
	public Student(String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		stNo = ++stCnt;  
		
		this.tot = kor+eng+mat;
		this.avg = this.tot / 3.0;
		
		summary();
	}
		
	private void refresh() {
		this.tot = kor+eng+mat;
		this.avg = this.tot / 3.0;
	}
	
	public static void headerPrint() {
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("\t\t   성   적   표                     ");
		System.out.println("-----------------------------------------------------");
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균 ");
		System.out.println("-----------------------------------------------------");
	}
	
	public static void footerPrint() {
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}
	
	public void itemPrint() {
		System.out.printf(this.infoString());
	}
	
	public static void summaryPrint() {
		System.out.println("-----------------------------------------------------");
		System.out.printf("\t%s\t%3.0f\t%3.0f\t%3.0f\t%4.0f\t%4.1f\n","총점",sumItems[0],sumItems[1],sumItems[2],sumItems[3],sumItems[4]);
		System.out.printf("\t%s\t%3.1f\t%3.1f\t%3.1f\t%4.1f\t%4.1f\n","평균",avgItems[0],avgItems[1],avgItems[2],avgItems[3],avgItems[4]);
		System.out.println("-----------------------------------------------------");
	}
	
	
	public void summary() {
		sumItems[0] += this.getKor();
		sumItems[1] += this.getEng();
		sumItems[2] += this.getMat();
		sumItems[3] += this.getTot();
		sumItems[4] += this.getAvg();
				
		for (int i=0 ; i < sumItems.length ; ++i) {
			avgItems[i] = sumItems[i] / stCnt;
		}
	}
	
	public String infoString() {
		
		return String.format("%d\t%s\t%3d\t%3d\t%3d\t%4d\t%2.1f\n",stNo, name,kor,eng,mat,tot,avg);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
		refresh();
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
		refresh();
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
		refresh();
	}

	public int getTot() {
		return tot;
	}
	
	public double getAvg() {
		return avg;
	}	
}
