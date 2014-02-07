package org.team3042.AerialAssist.commands;

/**
 * This command the roller arm motor.
 *
 * @author Team 3042
 */
public class IntakeMotorStop extends CommandBase {

    public IntakeMotorStop() {
        /**
         * Use requires() here to declare subsystem dependencies
         */
        requires(INTAKE);
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
        INTAKE.idle();
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
