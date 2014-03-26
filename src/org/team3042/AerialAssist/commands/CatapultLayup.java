/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team3042.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Robotics
 */
public class CatapultLayup extends CommandGroup {
    
    public CatapultLayup() {
       addSequential(new CompressorStop());
        addSequential(new IntakePistonExtend());
        addSequential(new CatapultLayupForward());
        addSequential(new CatapultReverse());
        addSequential(new CompressorStart());
    }
}
