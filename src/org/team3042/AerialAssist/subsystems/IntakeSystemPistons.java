/*
 * Import needed libraries
 */
package org.team3042.AerialAssist.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
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
    DigitalInput armOutSensor = new DigitalInput(RobotMap.INTAKE_SWITCH_DIO_PORT); 
    private boolean extended = false;
    private final Timer timer = new Timer();

    public IntakeSystemPistons() {
    }

    public void initDefaultCommand() {
        setDefaultCommand(new IntakeMaintainPosition());
    }

    public void extend() {

        pistonArm.set(Relay.Value.kReverse);
        extended = true;
    }
    
    public boolean switchStatus(){
        return armOutSensor.get();
    }

    public void retract() {

        pistonArm.set(Relay.Value.kOn);
        extended = false;
    }

    public void maintain() {
        if (extended) {
            this.extend();
        } else {
            this.retract();
        }
    }

    public void timerStart() {
        if (extended == false) {
            timer.reset();
            timer.start();
        }

    }

    public void timerEnd() {
        timer.stop();
    }

    public double getTimer() {
        return timer.get();
    }
}
