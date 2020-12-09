package com.lec.ex08robot;

public class RobotOrder {
	
	public void action(Robot robot) {
		if( robot instanceof DanceRobot) {
			((DanceRobot) robot).dance();
		} else if (robot instanceof DrawRobot) {
			((DrawRobot) robot).draw();
		} else if (robot instanceof SingRobot) {
			((SingRobot) robot).sing();
		}
	}
}
