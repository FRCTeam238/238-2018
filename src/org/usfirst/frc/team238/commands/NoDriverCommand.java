package org.usfirst.frc.team238.commands;

import org.usfirst.frc.team238.core.AbstractCommand;
import org.usfirst.frc.team238.core.Command;
import org.usfirst.frc.team238.robot.Drivetrain;

public class NoDriverCommand extends AbstractCommand {
	
	Drivetrain myRobotDrive;
	
	public void prepare(){
		
	}
	
	public NoDriverCommand(Drivetrain myRobotDrive){
		
		this.myRobotDrive = myRobotDrive;
	}

	
	public void execute() {
		myRobotDrive.nobtnPressed();
		//myRobotDrive.shiftLow();
	}

	
	public void execute(double overRideValue) {
		
		
	}

}
