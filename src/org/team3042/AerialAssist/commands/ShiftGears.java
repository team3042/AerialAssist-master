/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team3042.AerialAssist.commands;

/**
 *
 * @author noah G
 */
public class ShiftGears extends CommandBase {
    boolean isHigh;
    public ShiftGears(boolean isHigh) {
        // Use requires() here to declare subsystem dependencies
      requires(shiftGears);
      this.isHigh = isHigh;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly wcshen this Command is scheduled to run
    protected void execute() {
      if (this.isHigh) {
          shiftGears.shiftHigh();
      } else {
          shiftGears.shiftLow();
      }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
