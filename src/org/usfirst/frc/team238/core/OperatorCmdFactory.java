package org.usfirst.frc.team238.core;

import java.util.HashMap;


import org.usfirst.frc.team238.robot.CrusaderCommon;
import org.usfirst.frc.team238.robot.Drivetrain;
import org.usfirst.frc.team238.robot.Navigation;
import org.usfirst.frc.team238.robot.Robot;
import org.usfirst.frc.team238.robot.Elevator;
import org.usfirst.frc.team238.robot.IntakeWrist;


import org.usfirst.frc.team238.robot.Elevator;
import org.usfirst.frc.team238.robot.IntakeWrist;

import RealBot.TrajectoryIntepreter;

import org.usfirst.frc.team238.commands.CommandStopEverything;
import org.usfirst.frc.team238.lalaPaths.Straight140;
import org.usfirst.frc.team238.lalaPaths.goStraight;
import org.usfirst.frc.team238.lalaPaths.leftScale;
import org.usfirst.frc.team238.lalaPaths.leftSwitch;
import org.usfirst.frc.team238.lalaPaths.rightSwitch;
import org.usfirst.frc.team238.commands.CommandRunTrajectoryOLD;
import org.usfirst.frc.team238.commands.CommandIntakeIn;
import org.usfirst.frc.team238.commands.CommandIntakeOut;
import org.usfirst.frc.team238.commands.CommandIntakeStraightOutAngle;
import org.usfirst.frc.team238.commands.CommandElevatorBottomHeight;
import org.usfirst.frc.team238.commands.CommandElevatorDown;
import org.usfirst.frc.team238.commands.CommandElevatorScaleHeight;
import org.usfirst.frc.team238.commands.CommandElevatorUp;
import org.usfirst.frc.team238.commands.CommandExtendWrist;
import org.usfirst.frc.team238.commands.CommandRetractWrist;
import org.usfirst.frc.team238.commands.CommandRunTrajectory;
import org.usfirst.frc.team238.commands.CommandShiftClimb;




public class OperatorCmdFactory {

	
	CommandStopEverything commandStopEverything;

	CommandRunTrajectory commadRunTrajectory;
	
	CommandShiftClimb commandShiftClimb;
	
	CommandRetractWrist commandRetractWrist;
	
	CommandExtendWrist commandExtendWrist;
	
	CommandIntakeIn commandIntakeIn;
	
	CommandIntakeOut commandIntakeOut;
	
	CommandElevatorUp commandElevatorUp;
	
	CommandElevatorDown commandElevatorDown;
	
	CommandElevatorBottomHeight commandElevatorBottomHeight;
	
	CommandElevatorScaleHeight commandElevatorScaleHeight;
	
	CommandIntakeStraightOutAngle commandIntakeStraightOutAngle;
	
	HashMap<Integer, Command> operatorCommands;
	
	
	public void init()
	{
	
	  operatorCommands = new HashMap<Integer, Command>(16);
	
	}
	
	/**
	 * Operator controls get binded here. Assigning a series of buttons and commands to a HashMap
	 * @param driveTrain
	 * @param theNavigation
	 * @param theVision
	 * @param theFuelHandler
	 * @param theClimber
	 * @param theRobot
	 * @return
	 */
	public HashMap<Integer, Command> createOperatorCommands(Drivetrain driveTrain,
	    Navigation theNavigation, Robot theRobot,
	    TrajectoryIntepreter theIntepreter, Elevator elevator, IntakeWrist intake)
	{
	  //Inputs get defined in CrusaderCommon
	  Integer[] multiButtonTestInput = {1,2,3,4,5}; //Test : Button input
	  
	  //Create command objects, passing objects into each of them
	  commandStopEverything = new CommandStopEverything(intake, elevator);     //<-------------------------------- EXAMPLE
	  commadRunTrajectory = new CommandRunTrajectory(driveTrain, leftScale.objects );
	  commandShiftClimb = new CommandShiftClimb(elevator);
	  commandIntakeIn = new CommandIntakeIn(intake);
	  commandIntakeOut = new CommandIntakeOut(intake);
	  commandElevatorUp = new CommandElevatorUp(elevator);
	  commandElevatorDown = new CommandElevatorDown(elevator);
	  commandExtendWrist = new CommandExtendWrist(intake);
      commandRetractWrist = new CommandRetractWrist(intake);
      commandElevatorBottomHeight = new CommandElevatorBottomHeight(elevator);
      commandElevatorScaleHeight = new CommandElevatorScaleHeight(elevator);
      commandIntakeStraightOutAngle = new CommandIntakeStraightOutAngle(intake);
      
      
	  
	  
	  //Assigns all command arrays and their specific inputs to the HashMap
	  operatorCommands.put(CrusaderCommon.stopEverythingInput, commandStopEverything); // <------- EXAMPLE
	  //operatorCommands.put(9, commadRunTrajectory);
	  operatorCommands.put(1, commandShiftClimb);
	  operatorCommands.put(6, commandIntakeIn);
	  operatorCommands.put(7, commandIntakeOut);
	  operatorCommands.put(11, commandElevatorUp);
	  operatorCommands.put(10, commandElevatorDown);
	  operatorCommands.put(2, commandExtendWrist);
	  operatorCommands.put(3, commandRetractWrist);
	  operatorCommands.put(9, commandElevatorBottomHeight);
	  operatorCommands.put(8, commandElevatorScaleHeight);
	  // operatorCommands.put(3, commandIntakeStraightOutAngle);
      
    
    //operatorCommands.put(multiButtonTestInput, twoButtonTestCommandArray); //Test : Command put
		
	  
		return operatorCommands;
		
	}

	
}
