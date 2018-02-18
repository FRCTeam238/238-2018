package org.usfirst.frc.team238.core;

import java.util.HashMap;

import org.usfirst.frc.team238.robot.Drivetrain;
import org.usfirst.frc.team238.robot.Navigation;
import org.usfirst.frc.team238.robot.Robot;
import org.usfirst.frc.team238.robot.Elevator;
import org.usfirst.frc.team238.robot.IntakeWrist;

import RealBot.TrajectoryFactory;
import RealBot.TrajectoryIntepreter;

import org.usfirst.frc.team238.commands.CommandDriveForward;
import org.usfirst.frc.team238.commands.CommandElevatorBottomHeight;
import org.usfirst.frc.team238.commands.CommandDriveBackwards;
import org.usfirst.frc.team238.commands.CommandTurnLeft;
import org.usfirst.frc.team238.commands.CommandTurnRight;
import org.usfirst.frc.team238.lalaPaths.goStraight;
import org.usfirst.frc.team238.lalaPaths.leftScale;
import org.usfirst.frc.team238.commands.CommandCurlForward;
import org.usfirst.frc.team238.commands.CommandDelay;
import org.usfirst.frc.team238.commands.CommandRunTrajectory;
import org.usfirst.frc.team238.lalaPaths.leftSwitch;
import org.usfirst.frc.team238.lalaPaths.rightSwitch;
import org.usfirst.frc.team238.commands.CommandRetractWrist;
import org.usfirst.frc.team238.commands.CommandShiftClimb;
import org.usfirst.frc.team238.commands.CommandElevatorUp;
import org.usfirst.frc.team238.commands.CommandElevatorDown;
import org.usfirst.frc.team238.commands.CommandElevatorScaleHeight;
import org.usfirst.frc.team238.commands.CommandElevatorSwitchHeight;
import org.usfirst.frc.team238.commands.CommandExtendWrist;
import org.usfirst.frc.team238.commands.CommandIntakeOut;
import org.usfirst.frc.team238.commands.CommandIntakeIn;

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
			Navigation myNavigation, Robot myRobot,Elevator elevator,IntakeWrist intake){
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
        
        cmd = new CommandRunTrajectory(robotDrive, rightSwitch.objects );
        autonomousCommands.put("CommandRunRightSwitchTrajectory", cmd);
        
        cmd = new CommandExtendWrist(intake);
        autonomousCommands.put("CommandExtendWrist",cmd);
        
        cmd = new CommandRetractWrist(intake);
        autonomousCommands.put("CommandRetractWrist",cmd);
        
        cmd = new CommandElevatorUp(elevator);
        autonomousCommands.put("CommandElevatorUp",cmd);
        
        cmd = new CommandElevatorDown(elevator);
        autonomousCommands.put("CommandElevatorDown",cmd);
        
        cmd = new CommandIntakeIn(intake);
        autonomousCommands.put("CommandIntakeIn",cmd);
        
        cmd = new CommandIntakeOut(intake);
        autonomousCommands.put("CommandIntakeOut",cmd);
        
        cmd = new CommandShiftClimb(elevator);
        autonomousCommands.put("CommandShiftClimb",cmd);
        
        cmd = new CommandElevatorScaleHeight(elevator);
        autonomousCommands.put("CommandElevatorScaleHeight",cmd);
        
        cmd = new CommandElevatorSwitchHeight(elevator);
        autonomousCommands.put("CommandElevatorSwitchHeight",cmd);
        
        cmd = new CommandElevatorBottomHeight(elevator);
        autonomousCommands.put("CommandElevatorBottomHeight",cmd);
        
        cmd = new CommandRunTrajectory(robotDrive, leftScale.objects );
        autonomousCommands.put("CommandRunLeftScaleTrajectory", cmd);
        
        //cmd = new CommandRunTrajectory(robotDrive, rightScale.objects );
        //autonomousCommands.put("CommandRunRightSwitchTrajectory", cmd);
        
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
