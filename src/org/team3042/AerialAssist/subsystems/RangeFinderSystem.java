/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team3042.AerialAssist.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team3042.AerialAssist.RobotMap;

/**
 *
 * @author t0211801v
 */
public class RangeFinderSystem extends Subsystem {

    private static final AnalogChannel rangeFinder = new AnalogChannel(RobotMap.RANGE_FINDER_ANALOG_PORT);

    public void initDefaultCommand() {
        //setDefaultCommand(new GetRange());
    }

    public static double getRange() {
        return rangeFinder.getVoltage() / .0098;
    }
}
