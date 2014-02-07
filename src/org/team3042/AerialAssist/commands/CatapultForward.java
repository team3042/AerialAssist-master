package org.team3042.AerialAssist.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team3042.AerialAssist.subsystems.CatapultSystem;

/**
 * TODO: Document this.
 *
 * @author Team 3042
 */
public class CatapultForward extends CommandBase {

    public static final int DANGLE = 200;
    public static final double SPEED = 0.75;
    private int stoppingTicks = 100;
    private double speed = SPEED;
    private final Timer timer = new Timer();

    /**
     * TODO: Document this.
     */
    public CatapultForward() {
        requires(CATAPULT_SYSTEM);
    }

    /**
     * TODO: Document this.
     */
    protected void initialize() {
        speed = SmartDashboard.getNumber("The Speed", SPEED);
        stoppingTicks = (int) (SmartDashboard.getNumber("The Angle", DANGLE) * CatapultSystem.ANGLE_TO_TICK);
        System.out.println(speed);
        System.out.println(stoppingTicks);
        timer.start();
    }

    /**
     * TODO: Document this.
     */
    protected void execute() {
        CATAPULT_SYSTEM.forward(speed);
    }

    /**
     * Finished when Catapult is at proper angle or timed out.
     *
     * @return Catapult angle is at stopping angle or timer has run out.
     */
    protected boolean isFinished() {
        return CATAPULT_SYSTEM.getEncoderCount() >= stoppingTicks || timer.get() >= CatapultSystem.TIME_SECONDS_FORWARD;
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