package com.lec.ex3_writer_reader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_Writer {
	public static void main(String[] args) {
		Writer writer = null;
		
		try {
			writer = new FileWriter("txtfile/2.txt");
			
			//char[] str = {'안','녕','하','세','요'};
			String str = "안녕하세요\r\n만나서 반가워요";
			//char[] st = str.toCharArray();
			
			//writer.write(st);
			writer.write(str);
					
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (writer != null)	writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		
	}
}
