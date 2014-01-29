package org.team3042.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * TODO: Document this.
 * 
 * This command assumes that one of the fire plans has been set first.
 *
 * @author Chip
 */
public class CatapultFire extends CommandGroup {
    
    /**
     * TODO: Document this.
     */
    public CatapultFire() {
        addSequential(new CatapultForward());
        addSequential(new CatapultReverse());
        
    }
}
