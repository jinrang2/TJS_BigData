package com.lec.loop;

import java.util.Scanner;

public class Homework04 {

	public static void main(String[] args) {
		
		boolean winStat =  false;
		int you ;
		Scanner scanner = new Scanner(System.in);
		String youStr="", comStr="", matchStr="",leftStr="     ", rightStr="     ";
		
		do {
			System.out.print("����(0), ����(1), ��(2)�� �ϳ��� �Է����ּ���? [�̱涧 ���� �ݺ�]: ");
			you = scanner.nextInt();
			
			int computer=(int) (Math.random()*3);
			
			if(you==0)			{	youStr = "����";	} 
			else if (you == 1)	{	youStr = "����";	}
			else if (you == 2)	{	youStr = "��";		} 
			else if (you != -1)	{	System.out.println("��!");	continue;	} 
			else 				{	break;				}
			
			if(computer==0) 		{	comStr = "����";	} 
			else if (computer == 1) {	comStr = "����";	} 
			else if (computer == 2) {	comStr = "��";		} 		
			
			if ( you == computer)		{	matchStr = "Draw";	} 
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
			System.out.printf("��� %s\t\t��ǻ�� %s\n",leftStr,rightStr);
			System.out.printf("%s\t\t%s\t\t%s\n",youStr,matchStr,comStr);
			System.out.println("#######################################");
			
		}while ( matchStr != ">");
		
		System.out.println("#### �����մϴ�! ������ �����մϴ�. ###");
		System.out.println("#######################################");
		scanner.close();
	}
}
