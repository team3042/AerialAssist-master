/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team3042.AerialAssist.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team3042.AerialAssist.subsystems.DriveTrainSystem;

/**
 * Drive the robot forward for n inches
 * @author jjkoletar
 */
public class PIDDrive extends CommandBase {
    private final double inches;
    private PIDController leftDrive;
    private PIDController rightDrive;
    private final Timer timer = new Timer();
    
    private static final double PID_P = 0.2;
    private static final double PID_I = 0.0;
    private static final double PID_D = 0.0;
    private static final double PID_TIMEOUT = 3;
    /**
     * Statically accumulate left and right drive values, then send them to the 
     * drivetrain object after both left and right have been set
     * 
     * NB this can get wonky if statics are not behaving as expected
     */
    private static class PIDProxy implements PIDOutput {
        private static double leftToWrite = 0;
        private static boolean leftSet = false;
        private static double rightToWrite = 0;
        private static boolean rightSet = false;
        
        private boolean isLeft;
        public PIDProxy(boolean isLeft) {
            this.isLeft = isLeft;
        }
        public void pidWrite(double output) {
            //System.out.println("Writing to " + (isLeft ? "LEFT" : "RIGHT") + " value " + output);
            if (this.isLeft) {
                PIDProxy.leftToWrite = output;
                PIDProxy.leftSet = true;
            }
            if (!this.isLeft) { 
                PIDProxy.rightToWrite = output;
                PIDProxy.rightSet = true;
            }
            if (PIDProxy.rightSet && PIDProxy.leftSet) {
                //Send the values to the drivetrain and reset our statics
                CommandBase.driveTrain.tankDrive(-leftToWrite, -rightToWrite);
                PIDProxy.rightSet = false;
                PIDProxy.leftSet = false;
            }
        }
    }
    public PIDDrive(double inches) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
        this.inches = inches;    }

    // Called just before this Command runs the first time
    protected void initialize() {
        double p, i, d;
        p = SmartDashboard.getNumber("P", PID_P);
        i = SmartDashboard.getNumber("I", PID_I);
        d = SmartDashboard.getNumber("D", PID_D);
        driveTrain.encoderStart(); // Start encoder accum and set the conversion factor
        driveTrain.driveLeftEncoder.setReverseDirection(true);
        driveTrain.driveLeftEncoder.setPIDSourceParameter(PIDSource.PIDSourceParameter.kDistance);
        driveTrain.driveRightEncoder.setPIDSourceParameter(PIDSource.PIDSourceParameter.kDistance);
        leftDrive = new PIDController(p, i, d, driveTrain.driveLeftEncoder, new PIDProxy(true));
        rightDrive = new PIDController(p, i, d, driveTrain.driveRightEncoder, new PIDProxy(false));
        leftDrive.enable();
        rightDrive.enable();
        leftDrive.setInputRange(0, 100);
        rightDrive.setInputRange(0, 100);
        leftDrive.setSetpoint(inches);
        rightDrive.setSetpoint(inches);
        timer.start();
    }
private boolean doge = false;
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (!doge) {
            System.out.println("#### EXECUTING PIDDRIVE ###");
            doge = true;
        }
        SmartDashboard.putData("LPID", leftDrive);
        SmartDashboard.putData("RPID", rightDrive);
        SmartDashboard.putNumber("Left Enc", driveTrain.driveLeftEncoder.pidGet());
        //do nothing, the PIDs are doing it (i think)
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() > PID_TIMEOUT;
    }

    // Called once after isFinished returns true
    protected void end() {
        leftDrive.disable();
        rightDrive.disable();
        leftDrive.free();
        leftDrive = null;
        rightDrive.free();
        rightDrive = null;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        leftDrive.disable();
        rightDrive.disable();
        leftDrive.free();
        leftDrive = null;
        rightDrive.free();
        rightDrive = null;
    }
}
