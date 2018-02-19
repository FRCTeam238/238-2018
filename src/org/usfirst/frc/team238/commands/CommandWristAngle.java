package org.usfirst.frc.team238.commands;

import org.usfirst.frc.team238.core.AbstractCommand;
import org.usfirst.frc.team238.core.Command;
import org.usfirst.frc.team238.robot.CrusaderCommon;
import org.usfirst.frc.team238.robot.IntakeWrist;

public class CommandWristAngle extends AbstractCommand {
	
    
	IntakeWrist extend; 
	double angle;
	
	public CommandWristAngle(IntakeWrist myextend)
	{
		this.extend = myextend;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		extend.setWrist(angle);

	}

	@Override
	public void execute(int btnPressed) {
		// TODO Auto-generated method stub
	    if(btnPressed ==1) {
	        extend.setWrist(90);
   
	    }
	}

	@Override
	public void prepare() {
		// TODO Auto-generated method stub

	}

	
	public void setParams(String params[]) {
	    if ((params[0] != null) || (!params[0].isEmpty())) {
	        angle = Double.parseDouble(params[0]);
	      } else {
	        angle = 0;
	      }
		// TODO Auto-generated method stub

	}
	
	public void stop() {
	    extend.stop();
	}

	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return true;
	}

}
