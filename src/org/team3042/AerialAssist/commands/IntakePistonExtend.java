/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team3042.AerialAssist.commands;

/**
 *
 * @author Team 3042
 */
public class IntakePistonExtend extends CommandBase {

    private static final double TIME_END = 2.0;

    public IntakePistonExtend() {
        requires(intakePiston);
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        intakePiston.timerStart();
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        intakePiston.extend();
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     */
    protected boolean isFinished() {
        boolean finished = false;
        System.out.println(intakePiston.getTimer());
        if (intakePiston.getTimer() >= TIME_END) {
            finished = true;
        }
        return finished;
    }

    /**
     * Called once after isFinished returns true
     */
    protected void end() {
    }

    /**
     * Called when another command which requires one or more of the same
     * subsystems is scheduled to run
     */
    protected void interrupted() {
    }
}
