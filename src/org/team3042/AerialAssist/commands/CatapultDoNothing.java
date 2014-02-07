package org.team3042.AerialAssist.commands;

/**
 * Stops movement of the cradle.
 *
 * @author Team 3042
 */
public class CatapultDoNothing extends CommandBase {

    /**
     * TODO: Document this.
     */
    public CatapultDoNothing() {
        requires(CATAPULT_SYSTEM);
    }

    /**
     * No initialization code required.
     */
    protected void initialize() {
    }

    /**
     * Stops movement of the cradle.
     */
    protected void execute() {
        CATAPULT_SYSTEM.doNothing();
    }

    /**
     * Finished when {@link CatapultSystem} is used for another purpose.
     *
     * @return false
     */
    protected boolean isFinished() {
        return false;
    }

    /**
     * TODO: Document this.
     */
    protected void end() {
    }

    /**
     * TODO: Document this.
     */
    protected void interrupted() {
    }
}