/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team3042.AerialAssist.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team3042.AerialAssist.RobotMap;
import org.team3042.AerialAssist.commands.DriveTrainShiftGears;

/**
 *
 * @author Team 3042
 */
public class DriveTrainSystemGearShift extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Relay shiftSpike = new Relay(RobotMap.DRIVE_TRAIN_SHIFT_SPIKE_RELAY_PORT);
    private boolean isHigh;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveTrainShiftGears(false));
    }

    public void shiftHigh() {
        shiftSpike.set(Relay.Value.kReverse);
        isHigh = true;
    }

    public void shiftLow() {
        shiftSpike.set(Relay.Value.kOff);
        isHigh = false;
    }

    public boolean isHigh() {
        return isHigh;
    }
}
