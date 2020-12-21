package com.lec.ex1_inputStreamOutputStream;

import java.io.*;

public class Ex05_fileCopyStep1 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		
		try {
			long start = System.currentTimeMillis();
			is = new FileInputStream("txtFile/강.gif");
			os = new FileOutputStream("txtFile/강2.gif");
			int cnt = 0;
			
			while(true) {
				++cnt;
				int i = is.read(); // 1Byte
				if (i == -1)	break;
				os.write(i);
			}
			
			long end= System.currentTimeMillis();
			System.out.println("복사 시간 " + (end-start)/1000.0 + "초 " +cnt + "반복후 파일 용량 "+ cnt +"Byte 복사 성공");
			//System.out.println(cnt+ "반복 후 파일 복사 성공");
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (is != null)	is.close();
				if (os != null) os.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
