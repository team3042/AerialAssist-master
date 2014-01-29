package org.team3042.AerialAssist.commands;

/**
 * TODO: Document this.
 *
 * @author Chip
 */
public class CatapultDoNothing extends CommandBase {

    /**
     * TODO: Document this.
     */
    public CatapultDoNothing() {
        requires(catapult);
    }

    /**
     * TODO: Document this.
     */
    protected void initialize() {
    }

    /**
     * TODO: Document this.
     */
    protected void execute() {
        catapult.doNothing();
    }

    /**
     * TODO: Document this.
     *
     * @return
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
