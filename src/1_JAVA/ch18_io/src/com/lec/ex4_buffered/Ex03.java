package com.lec.ex4_buffered;

// 1.키보드로 출력 파일 이름 받음
// 2.파일의 내용은? (파일 쓰기를 하기 싫으면 x)
// 3.키모드에서 입력한 내용을 파일로 씁니다

import java.io.*;

public class Ex03 {
	public static void main(String[] args) {
		BufferedReader keyb = new BufferedReader(new InputStreamReader(System.in));
		Writer writer = null;
		//BufferedReader br = null;
		System.out.println("출력할 파일 이름은");
		
		try {
			String filename = keyb.readLine();
			writer = new FileWriter(filename,true);
			
			while (true) {
				System.out.println("출력할 파일 내용은 (원하지 않을 시 x) ?");
				String content = keyb.readLine();
				
				if(content.equalsIgnoreCase("x"))	break;
				
				writer.write(content+"\r\n");
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(writer != null)	writer.close();
				if(keyb != null)	keyb.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
