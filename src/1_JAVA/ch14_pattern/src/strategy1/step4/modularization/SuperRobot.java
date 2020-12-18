package strategy1.step4.modularization;

import strategy1.step4.component.*;

// 날수 있 미사일 
public class SuperRobot extends Robot {
	FlyImpl		fly;
	MissileImpl	missile;
	KnifeImpl	knife;
	
	public SuperRobot() {
		fly	 	= new FlyYes();
		missile = new MissileYes();
		knife	= new KnifeLaser();
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
