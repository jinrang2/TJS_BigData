package com.lec.ex2_dataInputStreamoutputStream;

import java.io.*;
import java.util.ArrayList;

public class Ex03_ProductList {
	public static void main(String[] args) {
		ArrayList<Product> products = new ArrayList<Product>();
		
		ProductFileInput(products);
		ProductConsolePrint(products);
	}
	
	public static void ProductFileInput(ArrayList<Product> products) {
		InputStream		fis = null;
		DataInputStream	dis = null;
			
		try {
			fis = new FileInputStream("txtFile/product.dat");
			dis = new DataInputStream(fis);
			
			String name, eof="\r\n";
			int price, ps;
			
			while (true) {
				name	= dis.readUTF();
				price	= dis.readInt();
				ps		= dis.readInt();
				//eof		= dis.readUTF();
								
				products.add(new Product(name, price, ps));
			}
						
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("파일 입력을 종료합니다.");
		} finally {
			try {
				if (dis != null) 	dis.close();
				if (fis != null) 	fis.close();
			} catch (IOException e) {
				System.out.println("ex3");
				System.out.println(e.getMessage());
			}			
		}
	}
	
	public static void ProductConsolePrint(ArrayList<Product> products) {
		System.out.println("물건명\t가격\t개수");
		System.out.println("======================");
		
		/*for(Product p : products) {
			System.out.println(p);
		}*/
		
		//products.forEach(System.out::println);
		//products.forEach(s-> System.out.println(s));
		products.forEach(a-> System.out.println(a));
		
		
		System.out.println("======================");
	}
}
