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
		
		System.out.printf("합    계=%3d\t평    균=%2.2f\n",tot,avg);
		System.out.printf("최대값은=%3d\t최소값은=%2d",max,min);
		
	}
}
