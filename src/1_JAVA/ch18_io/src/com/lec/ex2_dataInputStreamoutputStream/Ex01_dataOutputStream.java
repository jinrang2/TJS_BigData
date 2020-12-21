package com.lec.ex2_dataInputStreamoutputStream;

import java.io.*;

public class Ex01_dataOutputStream {

	public static void main(String[] args) {
		OutputStream	 fos = null; 
		DataOutputStream dos = null;
		
		try {
			fos = new FileOutputStream("txtFile/dataFile.dat",true);
			dos = new DataOutputStream(fos);
			
			dos.writeUTF("홍길동");			// 스트링 저장
			dos.writeInt(2);
			dos.writeDouble(95.9);
			
			System.out.println("저장완료");
			 
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos != null)	dos.close();
				if (fos != null)	fos.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		 
		
	}

}
