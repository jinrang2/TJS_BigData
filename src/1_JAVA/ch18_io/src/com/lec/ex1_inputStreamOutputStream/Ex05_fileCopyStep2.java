package com.lec.ex1_inputStreamOutputStream;

import java.io.*;

public class Ex05_fileCopyStep2 {
	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		
		final int BUF = 1024; 
		
		try {
			//File oroginalFile = new File("txtFile/강.gif");
			long start = System.currentTimeMillis();
			is = new FileInputStream("txtFile/강.gif");
			os = new FileOutputStream("txtFile/강2.gif");
			int cnt = 0;
			int storage = 0;
			byte[] bs = new byte[BUF];
			int readByteCnt = 0;
			
			while(true) {
				readByteCnt = is.read(bs); // 1Byte
				if (readByteCnt == -1)	{
					break;
				}
				
				++cnt;
				storage += readByteCnt;
								
				os.write(bs, 0 , readByteCnt);
			}
			
			long end= System.currentTimeMillis();
			System.out.println("복사 시간 " + (end-start)/1000.0 + "초 " +cnt + "반복후 파일 용량 "+ storage +"Byte 복사 성공");
			
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
