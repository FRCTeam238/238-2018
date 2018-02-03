package org.usfirst.frc.team238.core;

import java.util.HashMap;


import org.usfirst.frc.team238.robot.CrusaderCommon;
import org.usfirst.frc.team238.robot.Drivetrain;
import org.usfirst.frc.team238.robot.Navigation;
import org.usfirst.frc.team238.robot.Robot;

import org.usfirst.frc.team238.robot.Elevator;
import org.usfirst.frc.team238.robot.IntakeWrist;

import RealBot.TrajectoryIntepreter;

import org.usfirst.frc.team238.commands.CommandStopEverything;
import org.usfirst.frc.team238.commands.CommandRunTrajectoryOLD;

public class OperatorCmdFactory {

	
	CommandStopEverything commandStopEverything;

	CommandRunTrajectoryOLD commadRunTrajectory;
	
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
	  commadRunTrajectory = new CommandRunTrajectoryOLD(theIntepreter);
	  
	  //Assigns all command arrays and their specific inputs to the HashMap
	  operatorCommands.put(CrusaderCommon.stopEverythingInput, commandStopEverything); // <------- EXAMPLE
	  operatorCommands.put(1, commadRunTrajectory);
    
    //operatorCommands.put(multiButtonTestInput, twoButtonTestCommandArray); //Test : Command put
		
	  
		return operatorCommands;
		
	}

	
}
