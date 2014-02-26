package org.team3042.AerialAssist;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 *
 * @author Team 3042
 */
public class RobotMap {

    /**
     * Relay Ports
     */
    public static final int COMPRESSOR_SPIKE_RELAY_PORT = 8;//3; Breadboard 2 debug: change compressor port to 8
    public static final int INTAKE_SOLENOID_SPIKE_RELAY_PORT = 7;//breadboard 2: wrt solenoid weirdness, bandaid
    public static final int DRIVE_TRAIN_SHIFT_SPIKE_RELAY_PORT = 6;
    /**
     * Digital IO Ports
     */
    public static final int COMPRESSOR_PRESSURE_SWITCH_DIO_PORT = 3;
    public static final int CATAPULT_ENCODER_INPUT_A_DIO_PORT = 5;
    public static final int CATAPULT_ENCODER_INPUT_B_DIO_PORT = 6;
    public static final int DRIVE_ENCODER_INPUT_LEFT_A_DIO_PORT = 7;
    public static final int DRIVE_ENCODER_INPUT_LEFT_B_DIO_PORT = 8;
    public static final int DRIVE_ENCODER_INPUT_RIGHT_A_DIO_PORT = 9;
    public static final int DRIVE_ENCODER_INPUT_RIGHT_B_DIO_PORT = 10;
    /**
     * PWM Ports
     */
    public static final int INTAKE_ROLLER_JAGUAR_PWM_PORT = 1;
    public static final int CATAPULT_MOTOR_LEFT_PWM_PORT = 2;
    public static final int CATAPULT_MOTOR_RIGHT_PWM_PORT = 3;
    public static final int DRIVE_TRAIN_RIGHT_MOTOR_PWM_PORT = 4;
    public static final int DRIVE_TRAIN_LEFT_MOTOR_PWM_PORT = 5;
    /**
     * Analog Ports
     */
    public static final int RANGE_FINDER_ANALOG_PORT = 1;
    /**
     * USB Ports
     */
    public static final int JOYSTICK_1 = 1;
    public static final int JOYSTICK_2 = 2;
    public static final int JOYSTICK_3 = 3;
    /**
     * These are joystick buttons.
     */
    public static final int TRIGGER_BUTTON = 1;
    public static final int JOYSTICK_BUTTON_2 = 2;
    public static final int JOYSTICK_BUTTON_3 = 3;
    public static final int TANK_DRIVE_OVERRIDE = 3;
    public static final int JOYSTICK_BUTTON_4 = 4;
    public static final int JOYSTICK_BUTTON_5 = 5;
    public static final int JOYSTICK_BUTTON_6 = 6;
    public static final int JOYSTICK_BUTTON_7 = 7;
    public static final int JOYSTICK_BUTTON_8 = 8;
    public static final int JOYSTICK_BUTTON_9 = 9;
    public static final int JOYSTICK_BUTTON_10 = 10;
    public static final int JOYSTICK_BUTTON_11 = 11;
}
