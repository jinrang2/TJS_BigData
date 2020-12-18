package strategy1.step5.modularization;

import strategy1.step4.component.FlyYes;
import strategy1.step4.component.KnifeLaser;
import strategy1.step4.component.MissileYes;

// 날수 있 미사일 
public class SuperRobot extends Robot {
	public SuperRobot() {
		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new KnifeLaser());
	}	
}
