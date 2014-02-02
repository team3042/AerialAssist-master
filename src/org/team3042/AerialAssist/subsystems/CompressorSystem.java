/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team3042.AerialAssist.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team3042.AerialAssist.RobotMap;

/**
 *
 * @author Ethan
 */
public class CompressorSystem extends Subsystem {

    Compressor compressor =
            new Compressor(RobotMap.COMPRESSOR_PRESSURE_SWITCH_DIO_PORT,
            RobotMap.COMPRESSOR_SPIKE_RELAY_PORT);

    public CompressorSystem() {
        compressor.start();
    }

    public void initDefaultCommand() {
    }
}
