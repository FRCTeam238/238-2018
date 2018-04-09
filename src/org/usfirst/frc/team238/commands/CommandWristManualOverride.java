package org.usfirst.frc.team238.commands;

import org.usfirst.frc.team238.core.AbstractCommand;
import org.usfirst.frc.team238.robot.Drivetrain;
import org.usfirst.frc.team238.robot.IntakeWrist;

public class CommandWristManualOverride extends AbstractCommand {

    IntakeWrist wrist;

  public CommandWristManualOverride(IntakeWrist wrist) {
    this.wrist = wrist;
  }

  public void prepare() {

  }

  @Override
  public void execute() {
    // TODO Auto-generated method stub
    wrist.manualOverride(false);
  }

  // @Override
  public void execute(double overRideValue) {

    // TODO Auto-generated method stub
  }

  public void setParams() {

  }

  public boolean complete() {
    return true;
  }

}
