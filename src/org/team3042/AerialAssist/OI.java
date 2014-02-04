package org.team3042.AerialAssist;

/**
 * Import necessary libraries
 */
//FRC Libraries
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.team3042.AerialAssist.commands.CatapultFire;
import org.team3042.AerialAssist.commands.DriveTrainShiftGears;
import org.team3042.AerialAssist.commands.IntakeMotorIn;
import org.team3042.AerialAssist.commands.IntakeMotorOut;
import org.team3042.AerialAssist.commands.IntakeMotorStop;
import org.team3042.AerialAssist.commands.IntakePistonExtend;
import org.team3042.AerialAssist.commands.IntakePistonRetract;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    Joystick driverTankLeft = new Joystick(RobotMap.JOYSTICK_1);
    Joystick driverTankRight = new Joystick(RobotMap.JOYSTICK_2);
    Joystick gunner = new Joystick(RobotMap.JOYSTICK_3);

    public double getLeftSpeed() {
        return driverTankLeft.getY();
    }

    public double getRightSpeed() {
        return -driverTankRight.getY();
    }

    Button gb1 = new JoystickButton(gunner, RobotMap.JOYSTICK_BUTTON_1);
    Button gb2 = new JoystickButton(gunner, RobotMap.JOYSTICK_BUTTON_2);
    Button gb3 = new JoystickButton(gunner, RobotMap.JOYSTICK_BUTTON_3);
    Button gb4 = new JoystickButton(gunner, RobotMap.JOYSTICK_BUTTON_4);
    Button gb6 = new JoystickButton(gunner, RobotMap.JOYSTICK_BUTTON_6);
    Button gb5 = new JoystickButton(gunner, RobotMap.JOYSTICK_BUTTON_5);
    Button rjb1 = new JoystickButton(driverTankRight, RobotMap.JOYSTICK_BUTTON_1);
    Button rjb2 = new JoystickButton(driverTankRight, RobotMap.JOYSTICK_BUTTON_2);

    /**
     * This binds the controls to the correct commands
     */
    public OI() {
        /**
         * Driver Station gear shift
         */
        rjb1.whenPressed(new DriveTrainShiftGears(true));
        rjb2.whenPressed(new DriveTrainShiftGears(false));
        /**
         * Gunner Catapult
         */
        gb1.whenPressed(new CatapultFire());

        /**
         * Gunner Intake
         */
        gb2.whenPressed(new IntakeMotorStop());
        gb5.whenPressed(new IntakeMotorIn());
        gb6.whenPressed(new IntakeMotorOut());
        gb3.whenPressed(new IntakePistonExtend());
        gb4.whenPressed(new IntakePistonRetract());
    }
}
