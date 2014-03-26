/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team3042.AerialAssist.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team3042.AerialAssist.RobotMap;
import org.team3042.AerialAssist.commands.CompressorStart;

/**
 *
 * @author Team 3042
 */
public class CompressorSystem extends Subsystem {
    
    public boolean compressorDisable = false;

    Compressor compressor = new Compressor(RobotMap.COMPRESSOR_PRESSURE_SWITCH_DIO_PORT,
            RobotMap.COMPRESSOR_SPIKE_RELAY_PORT);

    public CompressorSystem() {
        compressor.start();
    }

    public void initDefaultCommand() {
        setDefaultCommand(new CompressorStart());
    }

    public void compressorStop() {
        compressor.stop();
    }

    public void compressorStart() {
        if (compressorDisable) {
            compressor.stop();
        }
        else {
            compressor.start();
        }
    }
}
