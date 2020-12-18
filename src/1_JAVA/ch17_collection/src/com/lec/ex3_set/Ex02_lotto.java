package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Ex02_lotto {
	public static void main(String[] args) {
		HashSet<Integer> lottos = new HashSet<Integer>();
		TreeSet<Integer> lotto2 = new TreeSet<Integer>();
		
		//long seed = System.currentTimeMillis();
		Random random = new Random();
		
		//System.out.println(lottos.size());
		
		while(lottos.size() < 6) {
			//System.out.println(lottos.size());
			lottos.add(random.nextInt(45)+1);
		}
		
		System.out.println(lottos);
	}
}	
