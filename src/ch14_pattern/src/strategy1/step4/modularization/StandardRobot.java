package strategy1.step4.modularization;

import strategy1.step4.component.FlyImpl;
import strategy1.step4.component.FlyNo;
import strategy1.step4.component.KnifeImpl;
import strategy1.step4.component.KnifeWood;
import strategy1.step4.component.MissileImpl;
import strategy1.step4.component.MissileYes;


public class StandardRobot extends Robot  {
	FlyImpl		fly;
	MissileImpl	missile;
	KnifeImpl	knife;
	
	public StandardRobot() {
		fly	 	= new FlyNo();
		missile = new MissileYes();
		knife	= new KnifeWood();
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
}
