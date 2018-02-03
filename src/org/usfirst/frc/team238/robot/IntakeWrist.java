package org.usfirst.frc.team238.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class IntakeWrist
{
    
    TalonSRX wristTalon;
    TalonSRX intakeMaster;
    VictorSPX intakeSlave;
    
    public IntakeWrist()
    {
        
    }
    
    public void init()
    {
        
        wristTalon = new TalonSRX(7);
        intakeMaster = new TalonSRX(4);
        intakeSlave = new VictorSPX(5);
        
        intakeSlave.follow(intakeMaster);
        
        wristTalon.setNeutralMode(NeutralMode.Brake);
        intakeMaster.setNeutralMode(NeutralMode.Brake);
        intakeSlave.setNeutralMode(NeutralMode.Brake);
        
        intakeSlave.set(ControlMode.PercentOutput, 0);
        intakeMaster.set(ControlMode.PercentOutput, 0);
        intakeSlave.set(ControlMode.PercentOutput, 0);
        
    }
    
    /**
     * Extends the wrist out to manipulate cubes
     */
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
    public void intakeIn()
    {
     
        intakeMaster.set(ControlMode.PercentOutput, CrusaderCommon.INTAKE_SPEED);
        
    }
    
    /**
     * Spit a cube out
     */
    public void intakeOut()
    {
     
        intakeMaster.set(ControlMode.PercentOutput, -CrusaderCommon.INTAKE_SPEED);
        
    }
    
    public void stop()
    {
        
        intakeMaster.set(ControlMode.PercentOutput, 0);
        wristTalon.set(ControlMode.PercentOutput, 0);
        
    }
    
}
