package org.team3042.AerialAssist.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team3042.AerialAssist.RobotMap;

/**
 * Finds the distance from the goal
 * @author Team 3042
 */
public class RangeFinderSystem extends Subsystem {

    private final AnalogChannel rangeFinder = new AnalogChannel(RobotMap.RANGE_FINDER_ANALOG_PORT);

    public void initDefaultCommand() {
    }

    /**
     * Returns Voltage converted to Inches.
     * @return Inches from goal
     */
    public double getRange() {
        return rangeFinder.getVoltage() / .0098;
    }
}
