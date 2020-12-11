package strategy1.step4.modularization;

import strategy1.step4.component.FlyImpl;
import strategy1.step4.component.FlyNo;
import strategy1.step4.component.KnifeImpl;
import strategy1.step4.component.KnifeNo;
import strategy1.step4.component.MissileImpl;
import strategy1.step4.component.MissileNo;

public class LowRobot extends Robot  {
	FlyImpl		fly;
	MissileImpl	missile;
	KnifeImpl	knife;
	
	public LowRobot() {
		fly	 	= new FlyNo();
		missile = new MissileNo();
		knife	= new KnifeNo();
	}

	public void actionFly() {
		//System.out.println("날 수 없다");
		fly.fly();
	}	
	
	public void actionMissile() {
		//System.out.println("미사일을 쏠 수 없다");
		missile.missile();
	}
	
	public void actionKnife() {
		//System.out.println("검이 없습니다");
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
