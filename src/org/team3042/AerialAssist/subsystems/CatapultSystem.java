package org.team3042.AerialAssist.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team3042.AerialAssist.RobotMap;
import org.team3042.AerialAssist.commands.CatapultDoNothing;

/**
 * Responsible for movement of the cradle (Fires the ball).
 *
 * @author Team 3042
 */
public class CatapultSystem extends Subsystem {

    /**
     * Converts an angle (degrees) to ticks of the {@link Encoder}.
     */
    public static final double ANGLE_TO_TICK = 1.5;
    
    /**
     * Seconds before {@link CatapultForward} and {@link CatapultReverse} commands time out.
     */
    public static final double TIME_SECONDS_FORWARD = 2;
    
    /**
     * Motor on left side of the cradle.
     */
    private final Jaguar catapultMotorLeft = new Jaguar(RobotMap.CATAPULT_MOTOR_LEFT_PWM_PORT);
    
    /**
     * Motor or right side of the cradle.
     */
    private final Jaguar catapultMotorRight = new Jaguar(RobotMap.CATAPULT_MOTOR_RIGHT_PWM_PORT);
    
    /**
     * Encoder that counts motor revolutions.
     * Used to calculate angle of the cradle.
     */
    private final Encoder catapultAngle = new Encoder(
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
     * Stopping speed of the motors.
     */
    private static final double MOTOR_STOP = 0.0;

    /**
     * Resets the {@link Encoder}.
     */
    public CatapultSystem() {
        resetAngle();
    }

    /**
     * Sets default {@link edu.wpi.first.wpilibj.command.Command} to {@link CatapultDoNothing}.
     */
    public void initDefaultCommand() {
        setDefaultCommand(new CatapultDoNothing());
    }

    /**
     * Moves cradle forward at given speed.
     * @param speed Speed of the motors
     */
    public void forward(double speed) {
        catapultMotorLeft.set(speed);
        catapultMotorRight.set(-speed);
    }

    /**
     * Returns encoder count.
     * @return 
     */
    public int getEncoderCount() {
        return -catapultAngle.get();
    }

    /**
     * Moves the cradle backward at given speed.
     * @param speed Speed of the motors.
     */
    public void reverse(double speed) {
        catapultMotorLeft.set(-speed);
        catapultMotorRight.set(speed);
    }

    /**
     * Stops the movement of the cradle.
     */
    public void doNothing() {
        catapultMotorLeft.set(MOTOR_STOP);
        catapultMotorRight.set(MOTOR_STOP);
    }

    /**
     * Resets the count of the encoder.
     */
    public final void resetAngle() {
        catapultAngle.reset();
        catapultAngle.start();
    }
}