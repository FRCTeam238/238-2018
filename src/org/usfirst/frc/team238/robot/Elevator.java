package org.usfirst.frc.team238.robot;

import org.usfirst.frc.team238.core.Logger;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Elevator
{
    
    private static final double MAX_OUT = 0.95;
    private static final double MIN_OUT = -0.95;
    
    private static final double MIN_HEIGHT = -80.0;
    private static final double MAX_HEIGHT = 86;
    
    
  
    private double setpoint = 0;
    private double currentError =0;
    
    //Really only a P loop
    private boolean PIDEnabled = true;
    
    TalonSRX elevatorMasterTalon;
    TalonSRX elevatorSlaveTalon;
    VictorSPX elevatorSlaveVictor;
    
    
    DoubleSolenoid solenoid;
    
    int liftEncoder;
    
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
        
        elevatorMasterTalon = new TalonSRX(CrusaderCommon.ELEVATOR_MASTER);
        elevatorSlaveTalon = new TalonSRX(CrusaderCommon.ELEVAOR_SLAVE_SRX);
        elevatorSlaveVictor = new VictorSPX(CrusaderCommon.ELEVATOR_SLAVE_SPX);
        
        elevatorSlaveTalon.set(ControlMode.Follower, CrusaderCommon.ELEVATOR_MASTER);//follow(elevatorMasterTalon);
        elevatorSlaveVictor.follow(elevatorMasterTalon);
        
        elevatorMasterTalon.setNeutralMode(NeutralMode.Brake);
        elevatorSlaveTalon.setNeutralMode(NeutralMode.Brake);
        elevatorSlaveVictor.setNeutralMode(NeutralMode.Brake);
        
        elevatorMasterTalon.set(ControlMode.PercentOutput, 0);
        elevatorMasterTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
        //elevatorMasterTalon.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
        
        elevatorMasterTalon.setSensorPhase(true);
        elevatorMasterTalon.config_kP(0, 0.004, 0);
        elevatorMasterTalon.setInverted(false);
        
        //elevatorMasterTalon.config
      
       
        
        solenoid = new DoubleSolenoid(6, 7);
        
        climbMode = false;
        
        resetEncoders();
        
        PIDEnabled = true;
        Runnable loop = ()->{
            while(true) {
                mainLoop();
                try
                {
                    Thread.sleep(30);
                }
                catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                 
            }
           };
        new Thread(loop).start();
    }
    
    public int getEncoderTicks()
    {
          liftEncoder = elevatorMasterTalon.getSelectedSensorPosition(0);
          
          liftEncoder = Math.abs(liftEncoder);
          
          SmartDashboard.putNumber("Lift Encoder", liftEncoder);
          
          return liftEncoder;
    }
    
    public void resetEncoders(){
        
        elevatorMasterTalon.setSelectedSensorPosition(0,0,0);
      
        liftEncoder = elevatorMasterTalon.getSelectedSensorPosition(0);
          
      }
    
    /**
     * Sends the elevator up at the speed used for cubes
     */
    
    
    public void elevatorUp()
    {
        //get encoder ticks
        PIDEnabled=false;
        int whereAmI = getEncoderTicks();
       elevatorMasterTalon.set(ControlMode.PercentOutput, CrusaderCommon.ELEVATOR_CUBE_SPEED);

    }
    
    /**
     * Sends the elevator down at the speed used for cubes
     */
    public void elevatorDown()
    {
        {
            PIDEnabled=false;
            //get encoder ticks
            int whereAmI = getEncoderTicks();
            elevatorMasterTalon.set(ControlMode.PercentOutput, -CrusaderCommon.ELEVATOR_CUBE_SPEED);
        }   
        
    }
    
    
    public void elevatorUpPID() {
        PIDEnabled=true;
        tilt(1);
    }
    
    public void elevatorDownPID() {
        PIDEnabled=true;
        tilt(-1);
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
    
    public void setElevatorHeight(double height) {
        PIDEnabled=true;
        elevatorMasterTalon.set(ControlMode.Position, height * ((double) CrusaderCommon.ELEVATOR_TICK_TO_IN));
       // System.out.println("ELEVATOR ERROR:" + elevatorMasterTalon.getClosedLoopError(0));
    }
    
    
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
        solenoid.set(DoubleSolenoid.Value.kForward);
        climbMode = false;
    }
    
    /**
     * Shift into climb speed
     */
    public void elevatorShiftClimb()
    {
        solenoid.set(DoubleSolenoid.Value.kReverse);
        climbMode = true;
    }
    
    public void enablePID() {
        PIDEnabled=true;
    }
    
    public void disablePID() {
        PIDEnabled=false;
    }
    
    //set height of robot
    public void setSetpoint(double height) {
        this.setpoint = Math.min(Math.max(MIN_HEIGHT, height), MAX_HEIGHT);;
    }
    
    public void tilt(double heightTilt) {
        setpoint+=heightTilt;
        this.setpoint = Math.min(Math.max(MIN_HEIGHT, setpoint), MAX_HEIGHT);;
    }
    
    public void mainLoop() {
        //nominal voltage <-1,1> outpu for elevator based in P gain
        if(PIDEnabled) {
            currentError = setpoint - getHeight();
            double outputWanted = currentError * CrusaderCommon.ELEVATOR_KP;
            outputWanted = Math.min(Math.max(MIN_OUT, outputWanted), MAX_OUT);
            elevatorMasterTalon.set(ControlMode.PercentOutput, outputWanted);
        }    
     
    }
    
    public double getHeight() {
       // System.out.println("HEIGHT:" + (-elevatorMasterTalon.getSelectedSensorPosition(0) / CrusaderCommon.ELEVATOR_TICK_TO_IN) + "      SETPOINT" + setpoint + "       ERROR:" + currentError);
        return -elevatorMasterTalon.getSelectedSensorPosition(0) / CrusaderCommon.ELEVATOR_TICK_TO_IN;
    }
}

