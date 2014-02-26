package org.team3042.AerialAssist.commands;

import org.team3042.AerialAssist.RobotMap;

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
        if (oi.driverRightJoystick.getRawButton(RobotMap.TANK_DRIVE_OVERRIDE)) {
            driveTrain.tankDrive(oi.driverRightJoystick, oi.driverRightJoystick);
        } else if (oi.driverLeftJoystick.getRawButton(RobotMap.TANK_DRIVE_OVERRIDE)) {
            driveTrain.tankDrive(oi.driverLeftJoystick, oi.driverLeftJoystick);
        } else {
            driveTrain.tankDrive(oi.driverLeftJoystick, oi.driverRightJoystick);
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
