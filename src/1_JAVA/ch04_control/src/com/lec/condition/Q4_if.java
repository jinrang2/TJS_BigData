package com.lec.condition;

import java.util.Scanner;

public class Q4_if {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Á¡¼ö¸¦ ÀÔ·ÂÇÏ¼¼¿ä :");
		int score = scanner.nextInt();
				
		if (score < 0 || score > 100) {
			System.out.println("¶½!");
		} else if (score >= 90 ) {
			System.out.println("A");
		} else if (score >= 80) {
			System.out.println("B");
		} else if (score >= 70) {
			System.out.println("C");
		} else if (score >= 60) {
			System.out.println("D");
		} else if (score >= 0) {
			System.out.println("F");
		}
		
		int score2 = score == 100  ? score-1 : score; 
		
		switch (score2/10) {
			case 9:
				System.out.println("A");	break;
			case 8:
				System.out.println("B");	break;
			case 7:
				System.out.println("C");	break;
			case 6:
				System.out.println("D");	break;
			case 5:	case 4: case 3: case 2: case 1: case 0:	
				System.out.println("F");	break;
			default:
				System.out.println("¶½!");	break;
		}
		
	}

}
