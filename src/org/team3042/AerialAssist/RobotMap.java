package org.team3042.AerialAssist;

import edu.wpi.first.wpilibj.Encoder;
import org.team3042.AerialAssist.subsystems.Catapult;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
   public static int leftJag;
    public static int rightJag;
    public static int leftJag1;
    public static int rightJag1;
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
   
    
    public static final int 
            
            SOLENOID_SPIKE_PORT = 6,
            
            COMPRESSOR_SPIKE_PORT = 3;
    /** 
     *digital IO port
     */  
    public static final int
            
            PRESSURE_SWITCH_PORT = 3;
    /**
     * PMW ports
     */
    public static final int ROLLER_ARM_JAGUAR_PORT = 1;
     public static int CATAPULT_MOTOR_LEFT = 2;
    public static int CATAPULT_MOTOR_RIGHT = 3;
    public static final int RIGHT_MOTOR = 4;
    public static final int LEFT_MOTOR = 5;
    
    

    public static final int
             /**
              * These are joystick buttons.
              */
            JOYSTICK_BUTTON_1 = 1,
            
            JOYSTICK_BUTTON_2 = 2,
            
            JOYSTICK_BUTTON_3 = 3,
            
             JOYSTICK_BUTTON_4 = 4,
            
            JOYSTICK_BUTTON_5 = 5,
            
             JOYSTICK_BUTTON_6 = 6,
            
             JOYSTICK_BUTTON_7 = 7,
            
             JOYSTICK_BUTTON_8 = 8,
            
             JOYSTICK_BUTTON_9 = 9,
             
             JOYSTICK_BUTTON_10 = 10,
             
             JOYSTICK_BUTTON_11 = 11;
      
    
     
    public static int SHOOT_BUTTON = 3;
    public static int REVERSE_BUTTON = 2;
    public static int SHOOT_REVERSE_BUTTON = 1;
    public static final int CATAPULT_ENCODER_INPUT_A = 5;
    public static final int CATAPULT_ENCODER_INPUT_B = 6;
    public static final int SHIFT_SPIKE = 7;
    
   
    public static Encoder ENCODER = new Encoder(RobotMap.CATAPULT_ENCODER_INPUT_A, 
            RobotMap.CATAPULT_ENCODER_INPUT_B);
    public static int CATAPULT_DOWN_POSITION_SWITCH;
    public static int rangeFinder;
    
    
}
