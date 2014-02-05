package org.team3042.AerialAssist.commands;

/**
 * This command starts the roller arm motor to grab a ball and bring it into the
 * robot.
 *
 * @author Team 3042
 */
public class IntakeMotorIn extends CommandBase {

    public IntakeMotorIn() {
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
        intake.ingest();
    }

    /**
     * Make this return true when this Command no longer needs to run execute()
     */
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
