package org.team3042.AerialAssist.commands;

/**
 *
 * @author Team 3042
 */
public class DriveTrainArcadeDrive extends CommandBase {

    public DriveTrainArcadeDrive() {

        requires(driveTrain);
    }

    protected void initialize() {
    }

    protected void execute() {
        driveTrain.arcadeDrive(oi.driverRightJoystick);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
