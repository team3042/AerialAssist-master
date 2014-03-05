/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team3042.AerialAssist.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Robotics
 */
public class AutoDrive108In extends CommandBase {

    private static final double DRIVE_SPEED = 1.0;
    private static final double DRIVE_STOP = 0.0;
    private static final double DRIVE_DISTANCE = 108;
    private static final double STOP_TIME = 100;
    private Timer timer = new Timer();
    public AutoDrive108In() {
        requires(driveTrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        driveTrain.encoderReset();
        driveTrain.encoderStart();
        timer.reset();
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        driveTrain.tankDrive(-DRIVE_SPEED, -DRIVE_SPEED);

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        boolean driveFinished = false;
        SmartDashboard.putNumber("Encoder auton", driveTrain.encoderAverage());
        if (driveTrain.encoderAverage() >= DRIVE_DISTANCE) {
            driveFinished = true;
        }
        if (timer.get()> STOP_TIME){
            driveFinished = true;
        }
        return driveFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
        driveTrain.tankDrive(DRIVE_STOP, DRIVE_STOP);
        driveTrain.encoderStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        driveTrain.tankDrive(DRIVE_STOP, DRIVE_STOP);
    }
}
