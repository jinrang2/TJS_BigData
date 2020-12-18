package strategy1.step2;

public class TestMain {
	public static void main(String[] args) {
		SuperRobot		superRobot		= new SuperRobot();
		StandardRobot	standardRobot	= new StandardRobot();
		LowRobot		lowRobot		= new LowRobot();
		
		Robot[] robots = {superRobot, standardRobot, lowRobot};
		
		for (Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionRun();
			robot.actionFly();
			robot.actionMissile();
			robot.actionKnife();
			
//			if(robot instanceof SuperRobot) {
//				SuperRobot temp = (SuperRobot)robot;
//				temp.actionFly();
//				temp.actionMissile();
//				temp.actionKnife();
//			} else if(robot instanceof StandardRobot) {
//				StandardRobot temp = (StandardRobot)robot;
//				temp.actionFly();
//				temp.actionMissile();
//				temp.actionKnife();
//			} else if(robot instanceof LowRobot) {
//				LowRobot temp = (LowRobot)robot;
//				temp.actionFly();
//				temp.actionMissile();
//				temp.actionKnife();
//			}			
		}
	}
}
