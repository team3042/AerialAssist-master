
package org.team3042.AerialAssist.commands;

/**
 *This turns the intake motor system to push the ball out of the robot.
 * 
 * Version 1.0 Ethan Dohm-Palmer
 */
public class IntakeExcrete extends CommandBase {
    
    public IntakeExcrete() {
        /**
         * Use requires() here to declare subsystem dependencies
         */
         requires(intake);
    }

    /**
     * Called just before this Command runs the first time
     */
    protected void initialize() {
    }

    /**
     * Called repeatedly when this Command is scheduled to run
     */
    protected void execute() {
        intake.excrete();
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     */
    protected boolean isFinished() {
        return false;
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