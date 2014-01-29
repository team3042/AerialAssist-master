
package org.team3042.AerialAssist.subsystems;
/**
 * Import needed libraries
 */
/**
*FRC Libraries
*/
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Team libraries
 */
import org.team3042.AerialAssist.RobotMap;
import org.team3042.AerialAssist.commands.IntakeIdle;

/**
 * The intake subsystem for the Aerial Assist robot
 * Team 3042 Eastview Cobalt Catalysts 
 * 
 * Version 1.0 Ethan Dohm-Palmer
 */
public class IntakeMotor extends Subsystem {

    // Speed values for roller arm.
    private static final double ROLLER_ARM_STOP    =  0.0;
    private static final double ROLLER_ARM_INGEST  =  0.5;
    private static final double ROLLER_ARM_EXCRETE = -0.5;
    
    /**
     * Create the subsystem objects.
     */
    SpeedController rollerArmMotor = new Jaguar(RobotMap.ROLLER_ARM_JAGUAR_PORT);

    /**
     * Default command for the intake arm.
     */
    public void initDefaultCommand() {
        setDefaultCommand(new IntakeIdle());
    }
    /**
     * Turn on the roller arm motors to grab ball.
     */
    public void ingest(){
        rollerArmMotor.set(ROLLER_ARM_INGEST);
    }
    /**
     * Turn on roller arm motor to ball out.
     */
    public void excrete(){
        rollerArmMotor.set(ROLLER_ARM_EXCRETE);
    }
    /**
     * Set the roller arm motor to stop.
     */
    public void idle(){
        rollerArmMotor.set(ROLLER_ARM_STOP);
    }
}

