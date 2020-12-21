package com.lec.ex3_writer_reader;

import java.io.*;

public class Ex01_Reader {
	public static void main(String[] args) {
		Reader reader = null;
		
		try {
			reader = new FileReader("txtFile/1.txt");
			
			while (true) {
				int i = reader.read();
				
				if (i==-1)	break;
				
				System.out.print((char)i);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(reader != null)	reader.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
