package org.usfirst.frc.team238.commands;

import org.usfirst.frc.team238.core.AbstractCommand;
import org.usfirst.frc.team238.core.Command;
import org.usfirst.frc.team238.robot.Elevator;

public class CommandElevatorScaleHeight extends AbstractCommand
{

    Elevator theElevator;
    public CommandElevatorScaleHeight(Elevator myElevator) {
        this.theElevator = myElevator;
    }
        
    @Override
    public void execute()
    {
        theElevator.setElevatorHeight(30);
        // TODO Auto-generated method stub
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

    @Override
    public boolean done()
    {
        // TODO Auto-generated method stub
        return false;
    }

}
