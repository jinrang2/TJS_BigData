package com.lec.ex5_printwriter;

import java.io.*;

public class Ex01 {
	public static void main(String[] args) {
		PrintWriter printWriter = null;
		OutputStream os = null;
		Writer		writer = null;
		
		
		try {
			//printWriter = new PrintWriter("txtFile/ex1_1");
			//os = new FileOutputStream("txtFile/ex1_2.txt");
			//writer = new FileWriter("txtFile/1_3");
			printWriter = new PrintWriter("txtFile/5.txt");
			
			System.out.println("안녕하세요\n반갑습니다");
			printWriter.println("안녕하세요\r\n반갑습니다");
			System.out.print("개행 자동 안될 예정");
			printWriter.print("개행 안 될 예정\r\n");
			
			System.out.printf("%5s %3d %3d %5.1f\n","홍길동",99,98,98.5);
			printWriter.printf("%5s %3d %3d %5.1f\n","홍길동",99,98,98.5);
			
			System.out.printf("%5s %3d %3d %5.1f\n","김길동",100,100,100.0);
			printWriter.printf("%5s %3d %3d %5.1f\n","김길동",100,100,100.0);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if( printWriter != null)	printWriter.close();
			//if( writer != null)			writer.close();
			
		}
	
		
	}
}
