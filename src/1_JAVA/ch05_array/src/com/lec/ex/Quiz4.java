package com.lec.ex;

public class Quiz4 {
	public static void main(String[] args) {
		int[] iArr = {76,45,34,89,100,50,90,92};
		int tot = 0, min=1000, max = 0;
		double avg;
		
		for(int i : iArr) {
			tot += i;
			
			min = min > i ? i : min;
			max = max < i ? i : max;
		}
		
		avg = (double)tot/iArr.length;
		
		System.out.printf("��    ��=%3d\t��    ��=%2.2f\n",tot,avg);
		System.out.printf("�ִ밪��=%3d\t�ּҰ���=%2d",max,min);
		
	}
}
