/*
 * Import needed libraries
 */
package org.team3042.AerialAssist.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team3042.AerialAssist.RobotMap;
import org.team3042.AerialAssist.commands.IntakeMaintainPosition;

/**
 *
 * @author Team 3042
 */
public class IntakeSystemPistons extends Subsystem {

    /**
     * Create Subsystem objects
     */
    Relay pistonArm = new Relay(RobotMap.INTAKE_SOLENOID_SPIKE_RELAY_PORT);
    private boolean extended = false;

    public IntakeSystemPistons() {
    }

    public void initDefaultCommand() {
        setDefaultCommand(new IntakeMaintainPosition());
    }

    public void extend() {

        pistonArm.set(Relay.Value.kOn);
        extended = true;
    }

    public void retract() {

        pistonArm.set(Relay.Value.kReverse);
        extended = false;
    }

    public void maintain() {
        if (extended) {
            this.extend();
        } else {
            this.retract();
        }
    }
}
