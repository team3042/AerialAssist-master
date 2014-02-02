package org.team3042.AerialAssist.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team3042.AerialAssist.subsystems.CatapultSystem;

/**
 * TODO: Document this.
 *
 * @author Chip
 */
public class CatapultForward extends CommandBase {

    public static final int DANGLE = 200;
    public static final double SPEED = 0.75;
    private static final double TICK_TO_ANGLE = 1.5;
    private int stoppingAngle = 100;
    private double speed = SPEED;
    private Timer timer = new Timer();

    /**
     * TODO: Document this.
     */
    public CatapultForward() {
        requires(catapult);
    }

    /**
     * TODO: Document this.
     */
    protected void initialize() {
        speed = SmartDashboard.getNumber("The Speed", SPEED);
        stoppingAngle = (int) (SmartDashboard.getNumber("The Angle", DANGLE) * TICK_TO_ANGLE);
        System.out.println(speed);
        System.out.println(stoppingAngle);
        timer.start();
    }

    /**
     * TODO: Document this.
     */
    protected void execute() {
        catapult.forward(speed);
    }

    /**
     * TODO: Document this.
     *
     * @return
     */
    protected boolean isFinished() {
        double timeSeconds = timer.get();
        int currentAngle = catapult.getAngle();
        System.out.println(currentAngle);
        boolean angleReached = false;
        if (currentAngle >= stoppingAngle || timeSeconds > CatapultSystem.TIME_SECONDS_FORWARD) {
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
