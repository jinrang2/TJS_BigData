package com.lec.ex5_printwriter;

import java.io.*;
import java.util.ArrayList;

public class MainTest {
	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		customerConsoleInput(customers);
		
		customers.stream().forEach(System.out::println);
		
		customerFileOutput(customers);
		
		
		System.out.println("종료");
	}
	
	public static void customerConsoleInput(ArrayList<Customer> customers) {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			while (true) {
				System.out.println("회원 가입을 계속 진행하시겠습니까 (Y:진행 / n:입력시 종료)");
				String fn = keyboard.readLine();
				String name, phone, birth, address;
				
				if(fn.equalsIgnoreCase("n"))	break;
				if(!fn.equalsIgnoreCase("y"))	continue;
				
				System.out.println("이름 : ");
				name = keyboard.readLine();
				
				System.out.println("전화번호 : ");
				phone = keyboard.readLine();
				
				System.out.println("생일 : ");
				birth = keyboard.readLine();
				
				System.out.println("주소 : ");
				address = keyboard.readLine();
				
				customers.add(new Customer(name, phone, birth, address));
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (keyboard != null)	keyboard.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());			}
		}
		
	}
	
	public static void customerFileOutput(ArrayList<Customer> customers) {
		Writer writer = null;
		
		try {
			writer = new FileWriter("txtfile/2.txt");
			
			int n = customers.size();
			
			for (int i = 0; i< n ; i++) {
				writer.write(customers.get(i).toString()+"\r\n");  
			}
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (writer != null)	writer.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

































