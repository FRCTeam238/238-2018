package org.usfirst.frc.team238.robot;

import org.usfirst.frc.team238.core.Logger;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class IntakeWrist
{

    
    private static final double MAX_OUT = 0.6;
    private static final double MIN_OUT = -0.6;
    
    private static final double AUTO_MAX_OUT = 0.3;
    private static final double AUTO_MIN_OUT = -0.3;
    
    private static final double MIN_ANGLE = 3;
    private static final double MAX_ANGLE = 120;
    
    
    private double setpoint = 0;
    private double currentError =0;
    
    private boolean PIDEnabled = true;
    private boolean inAutonomous = false;
    
    TalonSRX wristTalon;
    TalonSRX intakeMaster;
    VictorSPX intakeSlave;
    
    public IntakeWrist()
    {
        
    }
    
    public void init()
    {
        
        wristTalon = new TalonSRX(CrusaderCommon.INTAKE_WRIST);
        intakeMaster = new TalonSRX(CrusaderCommon.INTAKE_MASTER_SRX);
        intakeSlave = new VictorSPX(CrusaderCommon.INTAKE_SLAVE);
        
        intakeSlave.follow(intakeMaster);
        
        wristTalon.setNeutralMode(NeutralMode.Brake);
        intakeMaster.setNeutralMode(NeutralMode.Brake);
        intakeSlave.setNeutralMode(NeutralMode.Brake);
        
        wristTalon.set(ControlMode.PercentOutput, 0);
        intakeMaster.set(ControlMode.PercentOutput, 0);
        intakeSlave.setInverted(true);
        
        wristTalon.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
        wristTalon.setSensorPhase(true);
        wristTalon.config_kP(0, 0.005, 0);
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
    
    /**
     * Extends the wrist out to manipulate cubes
     */
    
    //angle is 0 at top (starting configuraition) and then positive as i goes down.
    public void setWrist(double angle) {
        setpoint = Math.min(Math.max(MIN_ANGLE, angle), MAX_ANGLE);
        inAutonomous = false;
    }
    
    public void setWrist(double angle, boolean auto) {
        setpoint = Math.min(Math.max(MIN_ANGLE, angle), MAX_ANGLE);
        inAutonomous = auto;
    }
    
    public boolean usingWrist = false;
    public void extendWrist()
    {
        wristTalon.set(ControlMode.PercentOutput, CrusaderCommon.INTAKE_WRIST_SPEED);
        
    }
    
    /**
     * Retracts the wrist out to hide our intake
     */
    public void retractWrist()
    {
        
        wristTalon.set(ControlMode.PercentOutput, -CrusaderCommon.INTAKE_WRIST_SPEED);
        
    }
    
    /**
     * Suck a cube in
     */
    public void extendWristPID() {
        tilt(1.0);
        
    }
    
    public void retractWristPID() {
        tilt(-1.0);
    }
    
    public void tilt(double degrees) {
        setpoint+=degrees;
    }
    
    public void enablePID() {
        PIDEnabled=true;
    }
    
    public void disablePID() {
        PIDEnabled=false;
    }
    
    public void intakeIn()
    {
     
        intakeMaster.set(ControlMode.PercentOutput, -CrusaderCommon.INTAKE_SPEED);
    }
    
    /**
     * Spit a cube out
     */
    public void intakeOut()
    {
     
        intakeMaster.set(ControlMode.PercentOutput, CrusaderCommon.INTAKE_SPEED);
        
    }   
    
    public void intakeOutFast()
    {
     
        intakeMaster.set(ControlMode.PercentOutput, CrusaderCommon.INTAKE_SPEED_FAST);
        
    }
    
    public void stop()
    {
        
        intakeMaster.set(ControlMode.PercentOutput, 0.0);       
        
    }
    
    public void mainLoop() {
        if(PIDEnabled) {
            
            currentError = setpoint - getAngle();
            double outputWanted = currentError * CrusaderCommon.INTAKE_KP;
           
            if(inAutonomous) {
                outputWanted = Math.min(Math.max(AUTO_MIN_OUT, outputWanted+0.085), AUTO_MAX_OUT) ;
               // Logger.Log("Wrist Output Auto = " + outputWanted );
            }
            else
            {
                outputWanted = Math.min(Math.max(MIN_OUT, outputWanted+0.085), MAX_OUT) ;
               // Logger.Log("Wrist Output  Tele = " + outputWanted );
            }
           
            wristTalon.set(ControlMode.PercentOutput, outputWanted);
            
        }    
        
    }
    
    public double getAngle() {
        //System.out.println("INTAKE ANGLE:" + (-wristTalon.getSelectedSensorPosition(0) / CrusaderCommon.INTAKE_TICK_TO_DEGREE) + "      SETPOINT" + setpoint + "       ERROR:" + currentError);
        
        return -wristTalon.getSelectedSensorPosition(0)/ CrusaderCommon.INTAKE_TICK_TO_DEGREE;
    }
    
    public void resetEncoders(){
        
        wristTalon.setSelectedSensorPosition(0,0,0);
      
      }
    
    
    
}
