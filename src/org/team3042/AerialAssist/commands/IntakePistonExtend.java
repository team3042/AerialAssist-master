/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team3042.AerialAssist.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Team 3042
 */
public class IntakePistonExtend extends CommandBase {

    private static final double TIME_END = 2.0;

    private Timer timer = new Timer();

    public IntakePistonExtend() {
        requires(INTAKE_PISTON);
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
        timer.start();
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        INTAKE_PISTON.extend();
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     */
    protected boolean isFinished() {
        boolean finished = false;
        if (timer.get() >= TIME_END) {
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
