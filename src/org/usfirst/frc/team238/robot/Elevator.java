package org.usfirst.frc.team238.robot;

import org.usfirst.frc.team238.core.Logger;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Elevator
{
    
    TalonSRX elevatorMasterTalon;
    TalonSRX elevatorSlaveTalon;
    VictorSPX elevatorSlaveVictor;
    
    Solenoid highSolenoid;
    Solenoid lowSolenoid;
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
        elevatorMasterTalon.setSensorPhase(true);
        elevatorMasterTalon.config_kP(0, 0.004, 0);
        elevatorMasterTalon.setInverted(true);
        
        //elevatorMasterTalon.config
      
       
        
        highSolenoid = new Solenoid(4);
        lowSolenoid = new Solenoid(5);
        
        climbMode = false;
        
        resetEncoders();
    }
    
    public int getEncoderTicks()
    {

          
          liftEncoder = elevatorMasterTalon.getSelectedSensorPosition(0);
          
          liftEncoder = Math.abs(liftEncoder);
          
          //Logger.Log("Elevator: Lift Encoder = " + liftEncoder);
          
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
        int whereAmI = getEncoderTicks();
        
        //if (whereAmI < CrusaderCommon.ELEVATOR_TOP_SOFT_STOP) {
            elevatorMasterTalon.set(ControlMode.PercentOutput, CrusaderCommon.ELEVATOR_CUBE_SPEED);
      //  }else
       /// {
       //     elevatorMasterTalon.set(ControlMode.PercentOutput, 0.0);
      //  }
    }
    
    /**
     * Sends the elevator down at the speed used for cubes
     */
    public void elevatorDown()
    {
        {
            //get encoder ticks
            int whereAmI = getEncoderTicks();
            
           // if (whereAmI > CrusaderCommon.ELEVATOR_BOTTOM_SOFT_STOP) {
                elevatorMasterTalon.set(ControlMode.PercentOutput, -CrusaderCommon.ELEVATOR_CUBE_SPEED);
           // } else
           // {
           //     elevatorMasterTalon.set(ControlMode.PercentOutput, 0.0);
           // }
           
        }   
       
        
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
        elevatorMasterTalon.set(ControlMode.Position, height * ((double) CrusaderCommon.ELEVATOR_TICK_TO_IN));
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
