package com.lec.ex4_buffered;

import java.io.*;
import java.util.ArrayList;

// 키보드로 부터 파일이름을 받아 해당파일 출력
public class Ex02_bufferedReaderKeyboard {	
	public static void main(String[] args) {	
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		Reader 			reader = null;
		BufferedReader	br = null;
		System.out.println("읽어올 파일 이름은");
		
		try {	// txtFile/1.txt
			String filename = keyboard.readLine();
			File file = new File(filename);
			
			if (file.exists()) {
				reader = new FileReader(file);
				br = new BufferedReader(reader);
				
				while (true) {
					String line = br.readLine();
					if (line == null) break;
					
					System.out.println(line);
				}
				
				
			} else {
				System.out.println("파일이 없습니다");
			}
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
}
