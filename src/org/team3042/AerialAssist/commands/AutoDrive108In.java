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

    private static final double DRIVE_SPEED = 0.85;
    private static final double DRIVE_STOP = 0.0;
    public static double DRIVE_DISTANCE = 115; //166;  //106;
    private static final double STOP_TIME = 20;
    private double lOffset = 1;
    private double rOffset = 1;
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
        lOffset = SmartDashboard.getNumber("auto left", 1.0);
        rOffset = SmartDashboard.getNumber("auto right", 1.0);
        DRIVE_DISTANCE = SmartDashboard.getNumber("Auto Distance", DRIVE_DISTANCE);
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //if (stoppingAt == 0) {
            driveTrain.tankDrive(-DRIVE_SPEED * lOffset, -DRIVE_SPEED * rOffset);
            SmartDashboard.putNumber("Left encoder", driveTrain.driveLeftEncoder.getDistance());
            SmartDashboard.putNumber("Right encoder", driveTrain.driveRightEncoder.getDistance());
       // }        else { driveTrain.tankDrive(0, 0);}

    }
    double stoppingAt = 0;
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        boolean driveFinished = false;
        SmartDashboard.putNumber("Encoder auton", driveTrain.encoderAverage());
        if (driveTrain.encoderAverage() >= DRIVE_DISTANCE){ // && stoppingAt == 0) {
            driveFinished = true;
            //driveTrain.tankDrive(DRIVE_STOP, DRIVE_STOP);
            //stoppingAt = timer.get();
            
        }
       
        /*if (stoppingAt > 0 && timer.get() > (stoppingAt + 0.5)) {
            driveFinished = true;
        }*/
        if (timer.get() > STOP_TIME) {
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
