package com.lec.ex06toy;

public class MazingerToy implements IMoveArmLeg, IMissile {
	
	public MazingerToy() {
		System.out.println("마징가 장난감입니다");
		canMoveArmLeg();
		canMissile();
		System.out.println("=========================");
	}

	@Override
	public void canMissile() {
		System.out.println("마징가가 미사일을 쏩니다");
	}

	@Override
	public void canMoveArmLeg() {
		System.out.println("마징가가 팔다리를 움직입니다");
	}
	
	@Override
	public String toString() {
		return "팔다리 미사일 마징가";
	}

}
