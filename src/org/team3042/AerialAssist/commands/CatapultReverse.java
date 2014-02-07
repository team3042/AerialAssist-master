package org.team3042.AerialAssist.commands;

import edu.wpi.first.wpilibj.Timer;
import org.team3042.AerialAssist.subsystems.CatapultSystem;

/**
 * Moves Catapult backward, until at proper angle.
 *
 * @author Team 3042
 */
public class CatapultReverse extends CommandBase {

    private static final int STOPPING_TICKS = 20;
    private static final double SPEED = 0.15;
    private final Timer timer = new Timer();

    /**
     * TODO: Document this.
     */
    public CatapultReverse() {
        requires(CATAPULT_SYSTEM);
    }

    /**
     * Starts the timer.
     */
    protected void initialize() {
        timer.start();
    }

    /**
     * TODO: Document this.
     */
    protected void execute() {
        CATAPULT_SYSTEM.reverse(SPEED);
    }

    /**
     * Finished when Catapult is at proper angle or timed out.
     *
     * @return Catapult angle is at stopping angle or timer has run out.
     */
    protected boolean isFinished() {
        return CATAPULT_SYSTEM.getEncoderCount() <= STOPPING_TICKS || timer.get() >= CatapultSystem.TIME_SECONDS_FORWARD;
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