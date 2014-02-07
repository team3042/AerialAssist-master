/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team3042.AerialAssist.commands;

/**
 *
 * @author Team 3042
 */
public class IntakeMaintainPosition extends CommandBase {

    public IntakeMaintainPosition() {
        requires(INTAKE_PISTON);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        INTAKE_PISTON.maintain();
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
