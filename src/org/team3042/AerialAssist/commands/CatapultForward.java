package org.team3042.AerialAssist.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team3042.AerialAssist.subsystems.CatapultSystem;

/**
 * TODO: Document this.
 *
 * @author Team 3042
 */
public class CatapultForward extends CommandBase {

    public static final int DEFAULT_ANGLE = 120;//200;
    public static final double SPEED = 0.75;
    private static final double TICK_TO_ANGLE = 1.5;
    private int stoppingAngle = DEFAULT_ANGLE;
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
        speed = SmartDashboard.getNumber("The Forward Speed", SPEED);
        stoppingAngle = (int) (SmartDashboard.getNumber("The Angle", DEFAULT_ANGLE) * TICK_TO_ANGLE);
        System.out.println(speed);
        System.out.println(stoppingAngle);
        timer.start();
        String log = "Time: " + DriverStation.getInstance().getMatchTime() + ", Voltage: " + DriverStation.getInstance().getBatteryVoltage() + ", power: " + speed;
        System.out.println(log);
        DriverStationLCD d = DriverStationLCD.getInstance();
        d.println(DriverStationLCD.Line.kUser1, 1, "Time: " + DriverStation.getInstance().getMatchTime());
        d.println(DriverStationLCD.Line.kUser2, 1, "Voltage: " + DriverStation.getInstance().getBatteryVoltage());
        d.println(DriverStationLCD.Line.kUser3, 1, "Speed: " + speed);
        d.updateLCD();
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
