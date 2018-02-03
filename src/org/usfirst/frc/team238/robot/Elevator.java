package org.usfirst.frc.team238.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;

public class Elevator
{
    
    TalonSRX elevatorMasterTalon;
    TalonSRX elevatorSlaveTalon;
    VictorSPX elevatorSlaveVictor;
    
    Solenoid highSolenoid;
    Solenoid lowSolenoid;
    
    public boolean climbMode;
    
    /**
     * Constructor
     */
    public Elevator()
    {
        
    }
    
    /**
     * Initializes everything!
     */
    public void init()
    {
        
        elevatorMasterTalon = new TalonSRX(8);
        elevatorSlaveTalon = new TalonSRX(11);
        elevatorSlaveVictor = new VictorSPX(10);
        
        elevatorSlaveTalon.follow(elevatorMasterTalon);
        elevatorSlaveVictor.follow(elevatorMasterTalon);
        
        elevatorMasterTalon.setNeutralMode(NeutralMode.Brake);
        elevatorSlaveTalon.setNeutralMode(NeutralMode.Brake);
        elevatorSlaveVictor.setNeutralMode(NeutralMode.Brake);
        
        elevatorMasterTalon.set(ControlMode.PercentOutput, 0);
        elevatorSlaveTalon.set(ControlMode.PercentOutput, 0);
        elevatorSlaveVictor.set(ControlMode.PercentOutput, 0);
        
        highSolenoid = new Solenoid(4);
        lowSolenoid = new Solenoid(5);
        
        climbMode = false;
    }
    
    /**
     * Sends the elevator up at the speed used for cubes
     */
    
    
    public void elevatorUp()
    {
        
        elevatorMasterTalon.set(ControlMode.PercentOutput, CrusaderCommon.ELEVATOR_CUBE_SPEED);
        
    }
    
    /**
     * Sends the elevator down at the speed used for cubes
     */
    public void elevatorDown()
    {
        
        elevatorMasterTalon.set(ControlMode.PercentOutput, -CrusaderCommon.ELEVATOR_CUBE_SPEED);
        
    }
    
    /**
     * Sends the elevator up at the speed used for climbing
     */
    public void elevatorClimbUp()
    {
        
        elevatorMasterTalon.set(ControlMode.PercentOutput, CrusaderCommon.ELEVATOR_CLIMB_SPEED);
        
    }
    
    /**,.
     * Sends the elevator down at the speed used for climbing
     */
    public void elevatorClimbDown()
    {
     
        elevatorMasterTalon.set(ControlMode.PercentOutput, -CrusaderCommon.ELEVATOR_CLIMB_SPEED);
        
    }
    
    public void stop()
    {
        elevatorMasterTalon.set(ControlMode.PercentOutput, 0);
    }
    
    /**
     * Shift into cube manipulation speed
     */
    public void elevatorShiftCube()
    {
        highSolenoid.set(true);
        lowSolenoid.set(false);
        climbMode = false;
    }
    
    /**
     * Shift into climb speed
     */
    public void elevatorShiftClimb()
    {
        lowSolenoid.set(true);
        highSolenoid.set(false);
        climbMode = true;
    }
}
