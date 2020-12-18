package strategy1.step5.modularization;

import strategy1.step4.component.FlyImpl;
import strategy1.step4.component.KnifeImpl;
import strategy1.step4.component.MissileImpl;

public abstract class Robot {
	private FlyImpl		fly;
	private MissileImpl	missile;
	private KnifeImpl	knife;
		
	public void shape() {
		System.out.println(this.getClass().getSimpleName() +"은 팔,다리,머리,몸통으로 이루어져 있다");
	}
	
	public void actionWalk() {
		System.out.println("걸을 수 있다.");		
	}
	
	public void actionRun() {
		System.out.println("뛸 수 있다");
	}
	
	public void actionFly() {
		//System.out.println("날 수 있다");
		fly.fly();
	}	
	
	public void actionMissile() {
		//System.out.println("미사일을 쏠 수 있다");
		missile.missile();
	}
	
	public void actionKnife() {
		//System.out.println("레이저검이 있습니다");
		knife.knife();
	}

	public void setFly(FlyImpl fly) {
		this.fly = fly;
	}

	public void setMissile(MissileImpl missile) {
		this.missile = missile;
	}

	public void setKnife(KnifeImpl knife) {
		this.knife = knife;
	}

	/**
	 * @return the fly
	 */
	public FlyImpl getFly() {
		return fly;
	}	
}
