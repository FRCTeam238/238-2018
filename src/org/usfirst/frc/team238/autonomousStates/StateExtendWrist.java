package org.usfirst.frc.team238.autonomousStates;

import org.usfirst.frc.team238.core.AutonomousState;
import org.usfirst.frc.team238.core.CommandController;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team238.commands.CommandExtendWrist;

public class StateExtendWrist implements AutonomousState
{
    CommandExtendWrist extendWristCommand;
    String parameters[];
    boolean done = false;
    
    
    @Override
    public void init()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void prepare()
    {
        // TODO Auto-generated method stub
        extendWristCommand.prepare();
        extendWristCommand.setParams();
    }

    @Override
    public void init(String[] params, CommandController theMcp)
    {
        // TODO Auto-generated method stub
        extendWristCommand = (CommandExtendWrist) theMcp.getAutoCmd("CommandExtendWrist");
    }

    @Override
    public void process()
    {
        Runnable run = () -> {
            long startTime = System.currentTimeMillis();
                
            done = false;
            while (System.currentTimeMillis() - startTime < 1000)
            {
                extendWristCommand.execute();
                try
                {
                    Thread.sleep(25);
                }
                catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            extendWristCommand.stop();
            done = true;
        };
        new Thread(run).start();
    }

    

    @Override
    public boolean done()
    {
        return done;
    }

    @Override
    public void reset()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void showParams()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateParams()
    {
        // TODO Auto-generated method stub
        String param1;
        String param2;
        String param3;
        String param4;
        String param5;

        param1 = SmartDashboard.getString("Param 1 - targetValue", "");
        parameters[0] = param1;
        param2 = SmartDashboard.getString("Param 2 - motorSpeed", "");
        parameters[1] = param2;
        param3 = SmartDashboard.getString("Param 3 - targetYaw", "");
        parameters[2] = param3;
        param4 = SmartDashboard.getString("Param 4 - ultrasonicTarget", "");
        parameters[3] = param4;
        param5 = SmartDashboard.getString("Param 5 - collisionToggle", "");
        // parameters[4] = param5;
    }

    @Override
    public String getParam(int value)
    {
        String output = "";
        if (parameters == null || parameters.length - 1 < value)
        {
            output = "";
        }
        else
        {
            output = parameters[value];
        }
        return output;
    }

}
