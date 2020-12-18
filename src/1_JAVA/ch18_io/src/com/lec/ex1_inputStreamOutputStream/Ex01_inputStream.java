package com.lec.ex1_inputStreamOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

// 1.파일을 연다(스트림 객체 생성)	2. 데이터를 읽는다(ior2byte)
public class Ex01_inputStream {
	public static void main(String[] args) {
		InputStream is = null;
		try {
			is = new FileInputStream("txtFile/1.txt");
			// 2. 데이터 읽기(1Byte단위로 반복)
			while(true) {
				int i = is.read();
				if (i == -1)	break;
				System.out.print((char)i);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			// 3. 파일 닫기
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
	}
}
