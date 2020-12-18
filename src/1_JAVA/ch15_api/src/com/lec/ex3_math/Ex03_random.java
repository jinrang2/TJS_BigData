package com.lec.ex3_math;

import java.util.Random;

public class Ex03_random {
	public static void main(String[] args) {
		/*System.out.println((int)(Math.random()*45)+1);
		Random random = new Random();
		
		System.out.println("int 난수 : "+ Math.abs( (random.nextInt()%46)));
		System.out.println("int 난수 : "+ random.nextInt());
		System.out.println("0~100까지 난수 : "+ random.nextInt(101));
		System.out.println("0~44까지 난수 : "+ random.nextInt(45));
		System.out.println("1~45까지 난수 : "+ (random.nextInt(45)+1));
		
		System.out.println("double 난수 : "+ random.nextDouble());
		System.out.println("T|F 난수 : "+ random.nextBoolean());
		System.out.println("T|F 난수 : "+ random.nextGaussian());*/
		
		int[] lotto = new int[6];
		int temp;
		int i=0,j=0;
		Random random = new Random();
		
		for (i=0; i < lotto.length ; ++i) {
			j=0;
			temp = random.nextInt(4)+1;
			
			while (j < i) {
				if( temp == lotto[j]) {
					System.out.println("중복발생");
					temp = random.nextInt(45)+1;
					lotto[i] = temp;
					i--;
					break;
				}				
			}
			
			lotto[i] = temp;
			
			System.out.println(lotto[i]);
		}
		
		/*for (int l : lotto) {
			System.out.print(l+"\t");
		}*/
	}
}
