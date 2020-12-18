package com.lec.ex4_Object;

//♥♣♣♠

public class Card {
	private char kind;
	private int num;
	
	public Card(char kind, int num) {
		this.kind = kind;
		this.num = num;
	}

	@Override
	public String toString() {
		return "[kind] : " + kind + ", [num]=" + num;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + kind;
		result = prime * result + num;
		return result;
	}

	@Override
	/*public boolean equals(Object obj) {
		if (this == obj)					return true;
		if (obj == null)					return false;
		if (getClass() != obj.getClass())	return false;
		Card other = (Card) obj;
		
		if (kind != other.kind)				return false;
		if (num != other.num)				return false;
		return true;
	}*/

	public boolean equals(Object otherCard) {
		if (this == otherCard)
			return true;
		
		if (otherCard != null && otherCard instanceof Card) {
			Card other = (Card)otherCard;
			
			if (this.kind == other.kind && this.num == other.num) {
				return true;
			}
		}

		return false;
	}
	
	
	
}
