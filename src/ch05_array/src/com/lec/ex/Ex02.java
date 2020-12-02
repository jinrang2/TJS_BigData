package com.lec.ex;

public class Ex02 {
	public static void main(String[] args) {
		int[] score = {10,20,30,40,50};
		//double[] hak = {4.5, 3,3, 3.0};
		//String[] names = {"È«±æµ¿","±è±æµ¿"};
		
		int[] s = score;
		
		for(int i : score) {
			System.out.println(i);
		}
		
		s[0]=100;
		
		for(int i : score) {
			System.out.println(i);
		}
		
		for(int i : s) {
			System.out.println(i);
		}
		
		
	}
}
