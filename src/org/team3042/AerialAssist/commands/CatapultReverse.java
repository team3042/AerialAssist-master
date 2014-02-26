package org.team3042.AerialAssist.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team3042.AerialAssist.subsystems.CatapultSystem;

/**
 * TODO: Document this.
 *
 * @author Team 3042
 */
public class CatapultReverse extends CommandBase {

    private static final int STOPPING_ANGLE = 20;
    private static final double SPEED = 0.15;
    private Timer timer = new Timer();

    /**
     * TODO: Document this.
     */
    public CatapultReverse() {
        requires(catapult);

    }

    /**
     * TODO: Document this.
     */
    protected void initialize() {
        timer.start();
    }

    /**
     * TODO: Document this.
     */
    protected void execute() {
        double speed = SmartDashboard.getNumber("The Reverse Speed", SPEED);
        catapult.reverse(speed);

    }

    /**
     * TODO: Document this.
     *
     * @return
     */
    protected boolean isFinished() {
        double timeSeconds = timer.get();
        int currentAngle = catapult.getAngle();
        boolean angleReached = false;
        if (currentAngle <= STOPPING_ANGLE || timeSeconds > CatapultSystem.TIME_SECONDS_FORWARD) {
            angleReached = true;
        }
        return angleReached;
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
