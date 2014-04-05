/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team3042.AerialAssist.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team3042.AerialAssist.subsystems.CatapultSystem;

/**
 *
 * @author Robotics
 */
public class CatapultFeedPass extends CommandBase {

    public static final int DEFAULT_ANGLE = 20;
    public static final double SPEED = 0.25;
    private static final double TICK_TO_ANGLE = 1.5;
    private int stoppingAngle = DEFAULT_ANGLE;
    private double speed = SPEED;
    private Timer timer = new Timer();
    public static final double CATAPULT_PASS_DELAY = .1;

    public CatapultFeedPass() {
        requires(catapult);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.start();
        catapult.resetAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (timer.get() > CATAPULT_PASS_DELAY) {
            catapult.forward(speed);
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        double timeSeconds = timer.get();
        int currentAngle = catapult.getAngle();
        SmartDashboard.putNumber("Catapult Encoder Value", catapult.getAngle());
        boolean angleReached = false;
        if (currentAngle >= stoppingAngle || timeSeconds > 1) {
            angleReached = true;
        }
        if (angleReached) {
            System.out.println("#############Angle reached: " + timer.get());
        }
        return angleReached;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
