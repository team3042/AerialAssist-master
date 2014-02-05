package org.team3042.AerialAssist.commands;

/**
 * When executed this command resets the zero angle of the encoder. Once set we
 * can do all calculations from a zero-basis.
 *
 * @author Team 3042
 */
public class CatapultResetAngleZero extends CommandBase {

    /**
     * TODO: Document this.
     */
    public CatapultResetAngleZero() {
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
        catapult.resetAngle();
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
