package org.team3042.AerialAssist.commands;

/**
 *
 * @author Team 3042
 */
public class DriveTrainTankDrive extends CommandBase {

    public DriveTrainTankDrive() {

        requires(driveTrain);
    }

    protected void initialize() {
    }

    protected void execute() {
        driveTrain.tankDrive(oi.driverLeftJoystick, oi.driverRightJoystick);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
