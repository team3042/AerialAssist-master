package org.team3042.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * TODO: Document this.
 *
 * This command assumes that one of the fire plans has been set first.
 *
 * @author Team 3042
 */
public class CatapultFire extends CommandGroup {

    /**
     * TODO: Document this.
     */
    public CatapultFire() {

        /**
         * Add a command so that default command for intake arm is maintain
         * position.
         */
        addSequential(new CompressorStop());
        addSequential(new IntakePistonExtend());
        addSequential(new CatapultForward());
        addSequential(new CatapultReverse());
        addSequential(new CompressorStart());


    }
}
