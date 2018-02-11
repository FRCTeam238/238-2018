package org.usfirst.frc.team238.robot;

import org.usfirst.frc.team238.core.Logger;

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
