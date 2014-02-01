package org.team3042.AerialAssist;
/**
 * Import necessary libraries
 */
//FRC Libraries
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.team3042.AerialAssist.RobotMap;
import org.team3042.AerialAssist.commands.CatapultFire;
import org.team3042.AerialAssist.commands.IntakeArmExtend;
import org.team3042.AerialAssist.commands.IntakeArmRetract;

//Team Libraries
import org.team3042.AerialAssist.commands.IntakeExcrete;
import org.team3042.AerialAssist.commands.IntakeGrab;
import org.team3042.AerialAssist.commands.IntakeIdle;
import org.team3042.AerialAssist.commands.IntakeIngest;
import org.team3042.AerialAssist.commands.IntakePass;
import org.team3042.AerialAssist.commands.IntakeStow;
import org.team3042.AerialAssist.commands.ShiftGears;
import org.team3042.AerialAssist.commands.TDrive;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    Joystick leftStick = new Joystick(1);
    Joystick rightStick = new Joystick(2);
    
    
    public double getLeftSpeed(){
        return leftStick.getY();
    }
    
    public double getRightSpeed(){
        return -rightStick.getY();
    }
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    
    //Define the control hardware
   
   /*
    TODO:Rename all when functions are determined.
    */
    Button ljb1 = new JoystickButton(leftStick, RobotMap.JOYSTICK_BUTTON_1);
    Button ljb2 = new JoystickButton(leftStick, RobotMap.JOYSTICK_BUTTON_2);
    Button ljb3 = new JoystickButton(leftStick, RobotMap.JOYSTICK_BUTTON_3);
    Button ljb4 = new JoystickButton(leftStick, RobotMap.JOYSTICK_BUTTON_4);
    Button ljb6 = new JoystickButton(leftStick, RobotMap.JOYSTICK_BUTTON_6);
    Button ljb5 = new JoystickButton(leftStick, RobotMap.JOYSTICK_BUTTON_5);
    Button ljb7 = new JoystickButton(leftStick, RobotMap.JOYSTICK_BUTTON_7);
    Button ljb8 = new JoystickButton(leftStick, RobotMap.JOYSTICK_BUTTON_8);
    Button ljb9 = new JoystickButton(leftStick, RobotMap.JOYSTICK_BUTTON_9);
    Button ljb10 = new JoystickButton(leftStick, RobotMap.JOYSTICK_BUTTON_10);
    Button ljb11 = new JoystickButton(leftStick, RobotMap.JOYSTICK_BUTTON_11);
    
    Button rjb1 = new JoystickButton(rightStick, RobotMap.JOYSTICK_BUTTON_1);
    Button rjb2 = new JoystickButton(rightStick, RobotMap.JOYSTICK_BUTTON_2);
    Button rjb3 = new JoystickButton(rightStick, RobotMap.JOYSTICK_BUTTON_3);
    Button rjb4 = new JoystickButton(rightStick, RobotMap.JOYSTICK_BUTTON_4);
    Button rjb6 = new JoystickButton(rightStick, RobotMap.JOYSTICK_BUTTON_6);
    Button rjb5 = new JoystickButton(rightStick, RobotMap.JOYSTICK_BUTTON_5);
    Button rjb7 = new JoystickButton(rightStick, RobotMap.JOYSTICK_BUTTON_7);
    Button rjb8 = new JoystickButton(rightStick, RobotMap.JOYSTICK_BUTTON_8);
    Button rjb9 = new JoystickButton(rightStick, RobotMap.JOYSTICK_BUTTON_9);
    Button rjb10 = new JoystickButton(rightStick, RobotMap.JOYSTICK_BUTTON_10);
    Button rjb11 = new JoystickButton(rightStick, RobotMap.JOYSTICK_BUTTON_11);
 
              
    /**
     * This binds the controls to the correct commands
     */
    public OI(){
    //Bind intake controls to the commands
        ljb1.whenPressed(new CatapultFire());
        
        ljb3.whenPressed(new IntakeStow());       
        ljb4.whenPressed(new IntakePass());
        
        ljb6.whenPressed(new IntakeGrab());
        ljb7.whenPressed(new IntakeIdle());
        ljb8.whenPressed(new IntakeIngest());
        ljb9.whenPressed(new IntakeExcrete());
        ljb10.whenPressed(new IntakeArmExtend());
        ljb11.whenPressed(new IntakeArmRetract());
        
        
        
        
                 
    }
}