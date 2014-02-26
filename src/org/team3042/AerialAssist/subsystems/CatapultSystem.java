package org.team3042.AerialAssist.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team3042.AerialAssist.RobotMap;
import org.team3042.AerialAssist.commands.CatapultDoNothing;

/**
 * TODO: Document this.
 *
 * @author Team 3042
 */
public class CatapultSystem extends Subsystem {

    public static final double TIME_SECONDS_FORWARD = 2;
    /**
     * TODO: Document this.
     */
    private final Jaguar CatapultMotorLeft = new Jaguar(RobotMap.CATAPULT_MOTOR_LEFT_PWM_PORT);
    /**
     * TODO: Document this.
     */
    private final Jaguar CatapultMotorRight = new Jaguar(RobotMap.CATAPULT_MOTOR_RIGHT_PWM_PORT);
    /**
     * TODO: Document this.
     */
    private final Encoder CatapultAngle = new Encoder(
            RobotMap.CATAPULT_ENCODER_INPUT_A_DIO_PORT,
            RobotMap.CATAPULT_ENCODER_INPUT_B_DIO_PORT);
    /**
     * TODO: Document this.
     */
    private static final boolean LEAF_SWITH_OPEN = true;
    /**
     * TODO: Document this.
     */
    private static final boolean LEAF_SWITCH_CLOSED = false;
    /**
     * TODO: Document this.
     */
    private static final double MOTOR_STOP = 0.0;

    /**
     * TODO: Document this.
     */
    public CatapultSystem() {
        CatapultAngle.reset();
        CatapultAngle.start();
    }

    /**
     * TODO: Document this.
     */
    public void initDefaultCommand() {
        setDefaultCommand(new CatapultDoNothing());
    }

    /**
     * TODO: Document this.
     */
    public void forward(double speed) {
        CatapultMotorLeft.set(-speed);//See reverse()
        CatapultMotorRight.set(-speed);
    }

    /**
     * TODO: Document this.
     */
    public int getAngle() {
        return -CatapultAngle.get();
    }

    /**
     * TODO: Document this.
     */
    public void reverse(double speed) {
        CatapultMotorLeft.set(speed); //Inversion of left motor direction for bot 2, also done in forward()
        CatapultMotorRight.set(speed);
    }

    /**
     * TODO: Document this.
     */
    public void doNothing() {
        CatapultMotorLeft.set(MOTOR_STOP);
        CatapultMotorRight.set(MOTOR_STOP);
    }

    /**
     * TODO: Document this.
     */
    public void resetAngle() {
        CatapultAngle.reset();
        CatapultAngle.start();
    }
}
