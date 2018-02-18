package org.usfirst.frc.team238.commands;

import org.usfirst.frc.team238.core.AbstractCommand;
import org.usfirst.frc.team238.core.Command;
import org.usfirst.frc.team238.robot.IntakeWrist;

public class CommandIntakeOut extends AbstractCommand
{
    IntakeWrist theIntake;
    
    public CommandIntakeOut(IntakeWrist myIntake)
    {
        this.theIntake = myIntake;
    }
    
    @Override
    public void execute()
    {
        theIntake.intakeOut();
    }

    @Override
    public void execute(int btnPressed)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void prepare()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void setParams()
    {
        // TODO Auto-generated method stub

    }
    
    public void stop() {
        theIntake.stop();
    }

    @Override
    public boolean done()
    {
        // TODO Auto-generated method stub
        return false;
    }

}
