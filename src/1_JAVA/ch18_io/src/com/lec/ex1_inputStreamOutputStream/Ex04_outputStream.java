package com.lec.ex1_inputStreamOutputStream;

import java.io.*;

public class Ex04_outputStream {
	public static void main(String[] args) {
		OutputStream os = null;
		
		try {
			os = new FileOutputStream("txtFile/out.txt",true);	// 파일을 추가 모드로 연다. 
			String str = "모두 다 안녕이 필요한 시국\r\n";
			byte[] bs = str.getBytes();
			os.write(bs);		// 파일 쓰기			
			System.out.println("성공");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if( os == null)	os.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
