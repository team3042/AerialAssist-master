/*
 * Import needed libraries
 */
package org.team3042.AerialAssist.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;


import org.team3042.AerialAssist.RobotMap;
import org.team3042.AerialAssist.commands.IntakeArmRetract;

/**
 *
 * @author Ethan
 */
public class IntakePistons extends Subsystem {
    /**
     * Create Subsystem objects
     */
    Relay pistonArm = new Relay(RobotMap.SOLENOID_SPIKE_PORT);

    public IntakePistons(){
    }
    public void initDefaultCommand() {
        setDefaultCommand(new IntakeArmRetract());
    }
    public void extend(){
        
        pistonArm.set(Relay.Value.kOn); 
        }
    public void retract(){
        
        pistonArm.set(Relay.Value.kOff);
        
    }
}