package com.lec.ex5_scanner;

import java.util.Scanner;

public class Ex03 {
	
	public static void main(String[] args) {
		boolean winStat =  false;
		int you;
		Scanner scanner = new Scanner(System.in);
		String youStr="", comStr="", matchStr="",leftStr="     ", rightStr="     ";
		
		
		do {
			System.out.print("가위, 바위, 보를 입력하세요? (이길때까지!): ");
			youStr = scanner.nextLine();
			String your = youStr.trim();
			
			int computer=(int) (Math.random()*3);
			
			if(your.equals("가위"))			{	you=0;	} 
			else if (your.equals("바위") )	{	you=1;	}
			else if (your.equals("보") )		{	you=2;	} 
			else {	System.out.println("떽!");	continue;	}
			
			if(computer==0) 		{	comStr = "가위";	} 
			else if (computer == 1) {	comStr = "바위";	} 
			else if (computer == 2) {	comStr = "보";		} 		
			
			if ( you == computer)	{	matchStr = "Draw";	} 
			else if ( you ==1 ) 	{	
				if (computer == 0)		{	matchStr = ">";		leftStr="(Win)";	rightStr="(Lose)";	winStat=true;} 
				else 					{	matchStr = "<";		leftStr="(Lose)";	rightStr="(Win)";	}
			}
			else if ( you == 0 )	{
				if (computer == 2) 		{	matchStr = ">";		leftStr="(Win)";	rightStr="(Lose)";	winStat=true;	} 
				else 					{	matchStr = "<";		leftStr="(Lose)";	rightStr="(Win)";	}
			}
			else if ( you == 2){
				if (computer == 1) 		{	matchStr = ">";		leftStr="(Win)";	rightStr="(Lose)";	winStat=true;	}
				else					{	matchStr = "<";		leftStr="(Lose)";	rightStr="(Win)";	}
			}
			
			System.out.println("#######################################");
			System.out.printf("당신 %s\t\t컴퓨터%s\n",leftStr,rightStr);
			System.out.printf("%s\t\t%s\t%s\n",youStr,matchStr,comStr);
			System.out.println("#######################################");			
			
		}while ( winStat == false);
		
		System.out.println("수고하셨습니다?");
		scanner.close();
	}
}
