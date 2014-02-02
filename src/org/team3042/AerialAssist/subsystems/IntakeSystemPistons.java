/*
 * Import needed libraries
 */
package org.team3042.AerialAssist.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team3042.AerialAssist.RobotMap;
import org.team3042.AerialAssist.commands.IntakePistonRetract;

/**
 *
 * @author Ethan
 */
public class IntakeSystemPistons extends Subsystem {

    /**
     * Create Subsystem objects
     */
    Relay pistonArm = new Relay(RobotMap.INTAKE_SOLENOID_SPIKE_RELAY_PORT);

    public IntakeSystemPistons() {
    }

    public void initDefaultCommand() {
        setDefaultCommand(new IntakePistonRetract());
    }

    public void extend() {

        pistonArm.set(Relay.Value.kOn);
    }

    public void retract() {

        pistonArm.set(Relay.Value.kOff);

    }
}