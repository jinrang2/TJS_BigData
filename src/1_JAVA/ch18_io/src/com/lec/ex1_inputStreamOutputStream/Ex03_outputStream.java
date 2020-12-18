package com.lec.ex1_inputStreamOutputStream;

import java.io.*;

public class Ex03_outputStream {
	public static void main(String[] args)  {
		OutputStream os = null;
		
		try {
			os = new FileOutputStream("txtFile/out.txt");		// 1. 파일열기
			byte[] bs = {'H','e','l','l','o','\r','\n','J','A','V','A'};

			for(int i =0 ; i<bs.length ; i++) {
				os.write(bs[i]);			// 2. 파일에 데이터 쓰기(반복)
			}
			
			System.out.println("성공");
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os != null)	os.close();		// 3. 파일 닫기
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
