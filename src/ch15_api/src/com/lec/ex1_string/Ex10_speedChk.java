package com.lec.ex1_string;

public class Ex10_speedChk {

	public static void main(String[] args) {
		String str = "A";
		long start, end;
		int TEST_CNT = 200000;
		start = System.currentTimeMillis();
		
		
		for (int i = 0 ;  i < TEST_CNT ; ++i) {
			str = str.concat("a");
		}
		
		end = System.currentTimeMillis();
		System.out.println("스트링 변경시간 : " + (end-start));
		
		start = System.currentTimeMillis();
		StringBuffer strBuff = new StringBuffer("A");
		for (int i = 0 ;  i < TEST_CNT ; ++i) {
			strBuff = strBuff.append("a");
		}
		
		end = System.currentTimeMillis();
		System.out.println("스트링버퍼 변경시간 : " + (end-start));

		start = System.currentTimeMillis();
		StringBuilder StrBuil = new StringBuilder("A");
		for (int i = 0 ;  i < TEST_CNT ; ++i) {
			StrBuil = StrBuil.append("a");
		}
		
		end = System.currentTimeMillis();
		System.out.println("스트링버퍼 변경시간 : " + (end-start));
		
	}

}
