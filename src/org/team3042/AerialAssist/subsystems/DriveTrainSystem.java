package org.team3042.AerialAssist.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team3042.AerialAssist.RobotMap;
import org.team3042.AerialAssist.commands.CommandBase;
import org.team3042.AerialAssist.commands.DriveTrainArcadeDrive;
import org.team3042.AerialAssist.commands.DriveTrainTankDrive;

/**
 *
 * @author Team 3042
 */
public class DriveTrainSystem extends Subsystem {

    private final RobotDrive robotDrive
            = new RobotDrive(RobotMap.DRIVE_TRAIN_LEFT_MOTOR_PWM_PORT,
                    RobotMap.DRIVE_TRAIN_RIGHT_MOTOR_PWM_PORT);
    private static final double LEFT_ADJUST = 1.0;
    private static final double RIGHT_ADJUST = 1.0;

    /**
     * Comment out the drive train you don't want to use.
     */
    public void initDefaultCommand() {
        setDefaultCommand(new DriveTrainTankDrive());
        //setDefaultCommand(new DriveTrainArcadeDrive());
    }

    public void tankDrive(Joystick leftJoystick, Joystick rightJoystick) {
        //robotDrive.tankDrive(leftJoystick, rightJoystick);
        double leftValue;
        double rightValue;
        if (CommandBase.shiftGears.isHigh()) {
            leftValue = leftJoystick.getY()*SmartDashboard.getNumber("Left Low Scale", 1.0);
            rightValue = rightJoystick.getY()*SmartDashboard.getNumber("Right Low Scale", 1.0);
        }
        else {
            leftValue = leftJoystick.getY()*SmartDashboard.getNumber("Left High Scale", 1.0);
            rightValue = rightJoystick.getY()*SmartDashboard.getNumber("Right High Scale", 1.0);
        }
        robotDrive.tankDrive(leftValue, rightValue);
    }
    
    

    public void arcadeDrive(Joystick joystick) {
        robotDrive.arcadeDrive(joystick);
    }
}
