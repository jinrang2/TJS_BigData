package com.lec.loop;

import java.util.Scanner;

public class Homework03 {

	public static void main(String[] args) {
		
		boolean winStat =  false;
		int you;
		Scanner scanner = new Scanner(System.in);
		String youStr="", comStr="", matchStr="",leftStr="     ", rightStr="     ";
		
		
		do {
			System.out.print("가위(0), 바위(1), 보(2)중 하나를 입력해주세요? [-1 입력시 종료]: ");
			you = scanner.nextInt();
			
			int computer=(int) (Math.random()*3);
			
			if(you==0)			{	youStr = "가위";	} 
			else if (you == 1)	{	youStr = "바위";	}
			else if (you == 2)	{	youStr = "보";		} 
			else if (you != -1)	{	System.out.println("떽!");	continue;	} 
			else 				{	break;				}
			
			if(computer==0) 		{	comStr = "가위";	} 
			else if (computer == 1) {	comStr = "바위";	} 
			else if (computer == 2) {	comStr = "보";		} 		
			
			if ( you == computer)	{	matchStr = "Draw";	} 
			else if ( you ==1 ) 	{	
				if (computer == 0)		{	matchStr = ">";		leftStr="(Win)";	rightStr="(Lose)";	} 
				else 					{	matchStr = "<";		leftStr="(Lose)";	rightStr="(Win)";	}
			}
			else if ( you == 0 )	{
				if (computer == 2) 		{	matchStr = ">";		leftStr="(Win)";	rightStr="(Lose)";	} 
				else 					{	matchStr = "<";		leftStr="(Lose)";	rightStr="(Win)";	}
			}
			else if ( you == 2){
				if (computer == 1) 		{	matchStr = ">";		leftStr="(Win)";	rightStr="(Lose)";	}
				else					{	matchStr = "<";		leftStr="(Lose)";	rightStr="(Win)";	}
			}
			
			System.out.println("#######################################");
			System.out.printf("사람 %s\t\t컴퓨터 %s\n",leftStr,rightStr);
			System.out.printf("%s\t\t%s\t\t%s\n",youStr,matchStr,comStr);
			System.out.println("#######################################");
			
		}while ( you != -1);
		
		System.out.println("게임을 종료합니다?");
		scanner.close();
	}
}
