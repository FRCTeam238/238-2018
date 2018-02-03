package org.usfirst.frc.team238.core;

import java.util.HashMap;

import org.usfirst.frc.team238.robot.Drivetrain;
import org.usfirst.frc.team238.robot.Navigation;
import org.usfirst.frc.team238.robot.Robot;

import RealBot.TrajectoryFactory;
import RealBot.TrajectoryIntepreter;

import org.usfirst.frc.team238.commands.CommandDriveForward;
import org.usfirst.frc.team238.commands.CommandDriveBackwards;
import org.usfirst.frc.team238.commands.CommandTurnLeft;
import org.usfirst.frc.team238.commands.CommandTurnRight;
import org.usfirst.frc.team238.lalaPaths.goStraight;
import org.usfirst.frc.team238.commands.CommandCurlForward;
import org.usfirst.frc.team238.commands.CommandDelay;
import org.usfirst.frc.team238.commands.CommandRunTrajectory;
import org.usfirst.frc.team238.lalaPaths.leftSwitch;

public class AutonomousCmdFactory {
	
//	CommandDriveForward autoDriveForward;
//	CommandDriveBackwards autoDriveBackwards;
//	CommandTurnLeft autoTurnLeft;
//	CommandTurnRight autoTurnRight;
//	CommandDelay delayCommand;
//	CommandCurlForward curlForward;
//	CommandRunTrajectory autoGoStraight;
	
	HashMap <String, Command> autonomousCommands;
	//TODO change that static 10
	public void init(){
		autonomousCommands = new HashMap<String, Command>(10);
	}
	
	
	public HashMap<String, Command> createAutonomousCommands(Drivetrain robotDrive,
			Navigation myNavigation, Robot myRobot){
	    AbstractCommand cmd;
	    
	    cmd  = new CommandDriveForward(robotDrive, myNavigation);
		autonomousCommands.put("CommandDriveForward", cmd );
		
		cmd = new CommandDriveBackwards(robotDrive);
		autonomousCommands.put("CommandDriveBackwards", cmd);
		
		cmd = new CommandTurnLeft(robotDrive, myNavigation);
		autonomousCommands.put("CommandTurnLeft", cmd);
		
		cmd = new CommandTurnRight(robotDrive, myNavigation);		
		autonomousCommands.put("CommandTurnRight", cmd);
		
		cmd = new CommandDelay(robotDrive, myNavigation);
		autonomousCommands.put("CommandDelay", cmd);
		
		cmd = new CommandCurlForward(robotDrive, myNavigation, myRobot);		
		autonomousCommands.put("CommandCurlForward", cmd);
    
		cmd = new CommandRunTrajectory(robotDrive, goStraight.objects );
		autonomousCommands.put("CommandRunGoStraightTrajectory", cmd);
    
		cmd = new CommandRunTrajectory(robotDrive, leftSwitch.objects );
        autonomousCommands.put("CommandRunLeftSwitchTrajectory", cmd);
        
		return autonomousCommands;
		
	}

//	public HashMap<String, Command> createAutonomousCommandsOLD(Drivetrain robotDrive,
//            Navigation myNavigation, Robot myRobot){
//        
//        AbstractCommand cmd  = new CommandDriveForward(robotDrive, myNavigation);
//        autonomousCommands.put("CommandDriveForward", cmd );
//        autoDriveBackwards = new CommandDriveBackwards(robotDrive);
//        autonomousCommands.put("CommandDriveBackwards", autoDriveBackwards);
//        autoTurnLeft = new CommandTurnLeft(robotDrive, myNavigation);
//        autonomousCommands.put("CommandTurnLeft", autoTurnLeft);
//        autoTurnRight = new CommandTurnRight(robotDrive, myNavigation);
//        autonomousCommands.put("CommandTurnRight", autoTurnRight);
//        delayCommand = new CommandDelay(robotDrive, myNavigation);
//        autonomousCommands.put("CommandDelay", delayCommand);
//        curlForward = new CommandCurlForward(robotDrive, myNavigation, myRobot);
//        autonomousCommands.put("CommandCurlForward", curlForward);
//    
//        autoGoStraight = new CommandRunTrajectory(robotDrive, goStraight.objects );
//        autonomousCommands.put("CommandRunGoStraightTrajectory", autoGoStraight);
//    
//        return autonomousCommands;
//        
//    }
}
