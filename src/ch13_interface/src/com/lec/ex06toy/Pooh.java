package com.lec.ex06toy;

public class Pooh implements IMoveArmLeg  {
	
	public Pooh() {
		System.out.println("곰돌이 푸입니다");
		canMoveArmLeg();
		System.out.println("=========================");
	}
	
	public void canMoveArmLeg() {
		System.out.println("곰돌이의 팔이 움직입니다");
	}
	
	@Override
	public String toString() {
		return "팔다리 푸";
	}
}
