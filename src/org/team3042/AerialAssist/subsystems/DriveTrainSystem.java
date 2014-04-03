package org.team3042.AerialAssist.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team3042.AerialAssist.RobotMap;
import org.team3042.AerialAssist.commands.CommandBase;
import org.team3042.AerialAssist.commands.DriveTrainTankDrive;

/**
 *
 * @author Team 3042
 */
public class DriveTrainSystem extends Subsystem {

    private final Jaguar leftDriveJag = new Jaguar(RobotMap.DRIVE_TRAIN_LEFT_MOTOR_PWM_PORT);
    private final Jaguar rightDriveJag = new Jaguar(RobotMap.DRIVE_TRAIN_RIGHT_MOTOR_PWM_PORT);
    private final RobotDrive robotDrive = new RobotDrive(leftDriveJag,
            rightDriveJag);
    /**
     * Encoder Conversion Factor
     */
    public static final double ENCODER_INCHES_PER_TICK = 0.0785;
    /**
     * Drive Train Encoders
     */
    //TODO jjkoletar 3/6/14 private->public
    public final Encoder driveLeftEncoder = new Encoder(
            RobotMap.DRIVE_ENCODER_INPUT_LEFT_A_DIO_PORT,
            RobotMap.DRIVE_ENCODER_INPUT_LEFT_B_DIO_PORT);
    public final Encoder driveRightEncoder = new Encoder(
            RobotMap.DRIVE_ENCODER_INPUT_RIGHT_A_DIO_PORT,
            RobotMap.DRIVE_ENCODER_INPUT_RIGHT_B_DIO_PORT);

    /**
     * Comment out the drive train you don't want to use.
     */
    public void initDefaultCommand() {
        setDefaultCommand(new DriveTrainTankDrive());
    }

    /**
     * Takes joysticks to tankdrive values.
     *
     * @param leftJoystick
     * @param rightJoystick
     */
    public void tankDrive(Joystick leftJoystick, Joystick rightJoystick) {
        this.tankDrive(leftJoystick.getY(), rightJoystick.getY());
    }

    /**
     * TankDrive using values
     *
     * @param leftSpeed
     * @param rightSpeed
     */
    public void tankDrive(double leftSpeed, double rightSpeed) {
        double leftValue;
        double rightValue;
        if (CommandBase.shiftGears.isHigh()) {
            leftValue = leftSpeed * SmartDashboard.getNumber("Left High Scale", 1.0);
            rightValue = rightSpeed * SmartDashboard.getNumber("Right Higjh Scale", 1.0);



        } else {
            leftValue = leftSpeed * SmartDashboard.getNumber("Left Low Scale", 1.0);
            rightValue = rightSpeed * SmartDashboard.getNumber("Right Low Scale", 1.0);

        }
        robotDrive.tankDrive(leftValue, rightValue);
    }

    public void arcadeDrive(Joystick joystick) {
        robotDrive.arcadeDrive(joystick);
    }

    public void encoderReset() {
        driveLeftEncoder.reset();
        driveRightEncoder.reset();
    }

    public void encoderStart() {
        driveLeftEncoder.setDistancePerPulse(ENCODER_INCHES_PER_TICK);
        driveRightEncoder.setDistancePerPulse(ENCODER_INCHES_PER_TICK);
        driveLeftEncoder.start();
        driveRightEncoder.start();
    }

    public void encoderStop() {
        driveLeftEncoder.stop();
        driveRightEncoder.stop();
    }

    public double encoderAverage() {
        // System.out.println("left" + driveLeftEncoder.getDistance());
        //  System.out.println("right" + driveRightEncoder.getDistance());
        //  double average = (Math.abs(driveLeftEncoder.getDistance())
        // + Math.abs(driveRightEncoder.getDistance())) * .5;
        double average = Math.abs(driveRightEncoder.getDistance());
        return average;

    }
}
