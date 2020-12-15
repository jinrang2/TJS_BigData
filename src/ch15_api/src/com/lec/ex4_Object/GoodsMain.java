package com.lec.ex4_Object;

public class GoodsMain {

	public static void main(String[] args) {
		Goods s1 = new Goods("a001","새우깡", 1100, 10);
		Goods s2 = new Goods("a002","버터칩", 2000, 10);
		Goods s3 = new Goods("a003","맛있는우유", 8500, 20);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		System.out.println();
		
		Customer c1 = new Customer("010-1234-9999", "홍길동");
		Customer c2 = new Customer("010-5678-8888", "김마동");
		Customer c3 = new Customer("010-8899-7777", "이동마");
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
	}

}
