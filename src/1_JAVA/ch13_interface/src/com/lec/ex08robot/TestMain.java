/**
 * 
 */
package com.lec.ex08robot;

/**
 * @author 정명곤
 * @date 2020. 12. 9.
 */
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DanceRobot aRobot = new DanceRobot();
		SingRobot bRobot = new SingRobot();
		DrawRobot cRobot = new DrawRobot();
		RobotOrder order = new RobotOrder();
		Robot[] robots = {aRobot, bRobot, cRobot};
		
		order.action(aRobot);
		order.action(bRobot);
		order.action(cRobot);
		
		for (Robot robot: robots) {
			order.action(robot);
		}
	}

}
