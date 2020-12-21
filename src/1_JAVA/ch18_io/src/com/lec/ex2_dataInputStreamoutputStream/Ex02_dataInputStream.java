package com.lec.ex2_dataInputStreamoutputStream;

import java.io.*;

public class Ex02_dataInputStream {

	public static void main(String[] args) {
		InputStream	 fis = null; 
		DataInputStream dis = null;
		
		try {
			fis = new FileInputStream("txtFile/dataFile.dat");
			dis = new DataInputStream(fis);
			
			String name		= dis.readUTF();
			int grade		= dis.readInt();
			double score	= dis.readDouble();
			
			System.out.printf("파일로 부터 입력받은 값은 \n %s\t%s\t%s\n",name,grade,score);
			
			System.out.println("저장완료");
			 
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				if (dis != null)	dis.close();
				if (fis != null)	fis.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		 
		
	}

}
