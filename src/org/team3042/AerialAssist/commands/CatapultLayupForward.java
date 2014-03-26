package org.team3042.AerialAssist.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team3042.AerialAssist.commands.CommandBase;
import org.team3042.AerialAssist.subsystems.CatapultSystem;

/**
 * TODO: Document this.
 *
 * @author Team 3042
 */
public class CatapultLayupForward extends CommandBase {
    
    public static final int DEFAULT_ANGLE = 75;//200;
    private static final double TICK_TO_ANGLE = 1.5;
    private double stoppingAngle = DEFAULT_ANGLE * TICK_TO_ANGLE;
    private double speed = 1.0;
    private Timer timer = new Timer();
    
    public CatapultLayupForward() {
        requires(catapult);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        catapult.resetAngle();
        
        /**AUTON ONLY shrink power if too high
        if (DriverStation.getInstance().isAutonomous()) {
            double voltage = DriverStation.getInstance().getBatteryVoltage();
            final double tooMuchPower = 12.64;
            if (voltage > tooMuchPower) {
                speed -= 0.025;
            }
            
            
        }
        */
        //System.out.println(speed);
        //System.out.println(stoppingAngle);
        timer.start();
        
        
    }

    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        catapult.forward(speed);
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        double timeSeconds = timer.get();
        int currentAngle = catapult.getAngle();
        boolean angleReached = false;
        if (currentAngle >= stoppingAngle || timeSeconds > CatapultSystem.TIME_SECONDS_FORWARD) {
            angleReached = true;
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
