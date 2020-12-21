package com.lec.ex2_dataInputStreamoutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex03_ProductWrite {
	public static void main(String[] args) {
		
		ArrayList<Product> products = new ArrayList<Product>();
				
		ProductConsoleInput(products);
		ProductConsolePrint(products);
		ProductFileOutput(products);
		
		System.out.println("프로그램을 종료합니다.");
	}
		
	public static void ProductConsoleInput(ArrayList<Product> products) {
		String fn="";
		Scanner sc = new Scanner(System.in);
		String name;
		int price, ps;
		
		while(true) {
			System.out.println("입력할 재고 데이터를 확인해주세요 (Y/N)");
			fn = sc.next();
			
			if(fn.equalsIgnoreCase("n")) 			break;
			if(fn.equalsIgnoreCase("y") == false) 	continue;
			
			System.out.print("물건명을 입력해주세요. : ");
			name = sc.next();
				
			System.out.print("가격을 입력해주세요. : ");
			price = sc.nextInt();
			
			System.out.print("개수를 입력해주세요. : ");
			ps = sc.nextInt();
			
			products.add(new Product(name, price, ps));			
		}
	}
	
	public static void ProductConsolePrint(ArrayList<Product> products) {
		System.out.println("물건명\t가격\t개수");
		System.out.println("======================");
		
		for(Product p : products) {
			System.out.println(p);
		}
		System.out.println("======================");
	}
	
	public static void ProductFileOutput(ArrayList<Product> products) {
		OutputStream		fos = null;
		DataOutputStream	dos = null;
			
		try {
			fos = new FileOutputStream("txtFile/product.dat");
			dos = new DataOutputStream(fos);
			
			int size=products.size();
			
			for(int i=0 ; i < size ; i++) {
				dos.writeUTF(products.get(i).getName());			// 스트링 저장
				dos.writeInt(products.get(i).getPrice());
				dos.writeInt(products.get(i).getPs());
				//dos.writeUTF("\r\n");
				System.out.println(products.get(i) + " 파일 입력 완료");
			}
						
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos != null) 	dos.close();
				if (fos != null) 	fos.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}			
		}
	}
}
