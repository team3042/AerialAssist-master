package org.team3042.AerialAssist.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * TODO: Document this.
 *
 * @author Team 3042
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
