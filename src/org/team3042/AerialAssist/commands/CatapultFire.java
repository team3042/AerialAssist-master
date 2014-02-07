package org.team3042.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Extends the arm, fires and reverses the cradle.
 *
 * @see IntakePistonExtend
 * @see CatapultForward
 * @see CatapultReverse
 * 
 * @author Team 3042
 */
public class CatapultFire extends CommandGroup {

    /**
     * Adds the necessary commands.
     */
    public CatapultFire() {
        /*
         * Add a command so that default command for intake arm is maintain
         * position.
         */
        addSequential(new IntakePistonExtend());
        addSequential(new CatapultForward());
        addSequential(new CatapultReverse());
    }
}
