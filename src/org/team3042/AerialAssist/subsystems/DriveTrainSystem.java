package org.team3042.AerialAssist.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team3042.AerialAssist.RobotMap;
import org.team3042.AerialAssist.commands.DriveTrainArcadeDrive;
import org.team3042.AerialAssist.commands.DriveTrainTankDrive;

public class DriveTrainSystem extends Subsystem {

    private final RobotDrive robotDrive
            = new RobotDrive(RobotMap.DRIVE_TRAIN_LEFT_MOTOR_PWM_PORT,
                    RobotMap.DRIVE_TRAIN_RIGHT_MOTOR_PWM_PORT);

    /**
     * Uncomment the drive train you want to use.
     */
    public void initDefaultCommand() {
        setDefaultCommand(new DriveTrainTankDrive());
        setDefaultCommand(new DriveTrainArcadeDrive());
    }

    public void tankDrive(Joystick leftJoystick, Joystick rightJoystick) {
        robotDrive.tankDrive(leftJoystick, rightJoystick);
    }

    public void arcadeDrive(Joystick joystick) {
        robotDrive.arcadeDrive(joystick);
    }
}
