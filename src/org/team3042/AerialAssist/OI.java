package org.team3042.AerialAssist;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team3042.AerialAssist.commands.CatapultFire;
import org.team3042.AerialAssist.commands.DriveTrainShiftGears;
import org.team3042.AerialAssist.commands.IntakeMotorIn;
import org.team3042.AerialAssist.commands.IntakeMotorStop;
import org.team3042.AerialAssist.commands.IntakePass;
import org.team3042.AerialAssist.commands.IntakePistonExtend;
import org.team3042.AerialAssist.commands.IntakePistonRetract;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 *
 * @author Team 3042
 */
public class OI {

    public Joystick driverLeftJoystick = new Joystick(RobotMap.JOYSTICK_1);
    public Joystick driverRightJoystick = new Joystick(RobotMap.JOYSTICK_2);
    private final Joystick gunner = new Joystick(RobotMap.JOYSTICK_3);
    private final Button rTrig = new JoystickButton(driverRightJoystick, RobotMap.TRIGGER_BUTTON);
    private final Button lTrig = new JoystickButton(driverLeftJoystick, RobotMap.TRIGGER_BUTTON);
    private final Button gb1 = new JoystickButton(gunner, RobotMap.TRIGGER_BUTTON);
    private final Button gb2 = new JoystickButton(gunner, RobotMap.JOYSTICK_BUTTON_2);
    private final Button gb3 = new JoystickButton(gunner, RobotMap.JOYSTICK_BUTTON_3);
    private final Button gb4 = new JoystickButton(gunner, RobotMap.JOYSTICK_BUTTON_4);
    private final Button gb6 = new JoystickButton(gunner, RobotMap.JOYSTICK_BUTTON_6);
    private final Button gb5 = new JoystickButton(gunner, RobotMap.JOYSTICK_BUTTON_5);

    /**
     * This binds the controls to the correct commands
     */
    public OI() {
        SmartDashboard.putNumber("Left Low Scale", .98);
        SmartDashboard.putNumber("Right Low Scale", 1.0);
        SmartDashboard.putNumber("Left High Scale", .9);
        SmartDashboard.putNumber("Right High Scale", 1.0);


        /**
         * When either drive trigger is held, shift to high gear
         */
        lTrig.whileHeld(new DriveTrainShiftGears(true));
        lTrig.whenReleased(new DriveTrainShiftGears(false));
        rTrig.whileHeld(new DriveTrainShiftGears(true));
        rTrig.whenReleased(new DriveTrainShiftGears(false));

        /**
         * Gunner Catapult
         */
        gb1.whenPressed(new CatapultFire());

        /**
         * Gunner Intake
         */
        gb2.whenPressed(new IntakeMotorStop());
        gb5.whenPressed(new IntakeMotorIn());
        gb6.whenPressed(new IntakePass());
        gb3.whenPressed(new IntakePistonExtend());
        gb4.whenPressed(new IntakePistonRetract());
    }
}
