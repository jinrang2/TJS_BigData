package com.lec.loop;

// i가 1일때 누적합은 X 이다. (i가 1~10까지)

public class Ex08While {

	public static void main(String[] args) {
		int i = 1, sum = 0;
		
		while(i <= 10) {
			sum += i;
			
			System.out.printf("i가 %2d 일 때 누적합은 %2d 이다 \n",i,sum);
			
			++i;
		}
		
		sum = 0;
		
		for (int j = 1; j <= 10 ; ++j) {
			sum += j;
			System.out.printf("i가 %2d 일 때 누적합은 %2d 이다 \n",j,sum);
		}
	}

}
