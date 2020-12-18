package strategy1.step5.modularization;

import strategy1.step4.component.*;

public class TestMain {
	public static void main(String[] args) {
		Robot superRobot	= new SuperRobot();
		Robot standardRobot	= new StandardRobot();
		Robot lowRobot		= new LowRobot();
		
		Robot[] robots = {superRobot, standardRobot, lowRobot};
		
		for (Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
						
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
			
			System.out.println();
		}
		
		System.out.println(System.identityHashCode(lowRobot.getFly()));
		lowRobot.setFly(new FlyYes());
		System.out.println(System.identityHashCode(lowRobot.getFly()));
		lowRobot.setFly(new FlyNo());
		System.out.println(System.identityHashCode(lowRobot.getFly()));
		
	}
}
