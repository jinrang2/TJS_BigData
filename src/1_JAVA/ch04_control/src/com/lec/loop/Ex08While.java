package com.lec.loop;

// i�� 1�϶� �������� X �̴�. (i�� 1~10����)

public class Ex08While {

	public static void main(String[] args) {
		int i = 1, sum = 0;
		
		while(i <= 10) {
			sum += i;
			
			System.out.printf("i�� %2d �� �� �������� %2d �̴� \n",i,sum);
			
			++i;
		}
		
		sum = 0;
		
		for (int j = 1; j <= 10 ; ++j) {
			sum += j;
			System.out.printf("i�� %2d �� �� �������� %2d �̴� \n",j,sum);
		}
	}

}
