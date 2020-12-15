package com.lec.ex4_Object;

public class Ex02_CardMain {
	public static void main(String[] args) {
		//♥♣◆♠
		Card[] cards = {new Card('♥',2),
						new Card('◆',7),
						new Card('♣',8)};
		
		Card yours = new Card('♣',8);
		
		System.out.println("당신 카드 :" +  yours);
		
		for(int idx=0; idx < cards.length ; idx++) {
			System.out.print(cards[idx]);
			if(yours.equals(cards[idx])) {
				System.out.println(" - 당신 카드와 일치합니다");
			} else {
				System.out.println(" - 당신 카드와 일치 하지 않습니다");
			}
		}
		
	}
}
