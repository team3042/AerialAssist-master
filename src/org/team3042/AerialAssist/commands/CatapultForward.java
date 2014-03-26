package org.team3042.AerialAssist.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team3042.AerialAssist.RobotTemplate;
import org.team3042.AerialAssist.subsystems.CatapultSystem;

/**
 * TODO: Document this.
 *
 * @author Team 3042
 */
public class CatapultForward extends CommandBase {

    public static final int DEFAULT_ANGLE = 115;//200;
    public static final double SPEED = 1.0;
    private static final double TICK_TO_ANGLE = 1.5;
    private int stoppingAngle = DEFAULT_ANGLE;
    private double speed = SPEED;
    private Timer timer = new Timer();
    private double oldPosition = 0.0;
    private double oldTime = 0.0;
    private double maxVelocity = 0;
    private double ANGLETOTICK = 0.67;
    

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
        catapult.resetAngle();
        
        System.out.println("Encoder Start Value:" + catapult.getAngle());
        
       /** HAVE NOT TESTED, NEED TO ADD A DASHBOARD BOOLEAN TO SOMEHOW MAKE THIS TRUE
        if (RobotTemplate.varyCatapult == true){
            if (DriverStation.getInstance().getBatteryVoltage() > 12.6){
                speed = (SmartDashboard.getNumber("The Forward Speed", SPEED))*(0.95);
            }
            else if (DriverStation.getInstance().getBatteryVoltage() < 12.4){
                speed = (SmartDashboard.getNumber("The Forward Speed", SPEED))*(1.05);
            }
            else{
                speed = SmartDashboard.getNumber("The Forward Speed", SPEED);
            }
        }
        
        else{
            speed = SmartDashboard.getNumber("The Forward Speed", SPEED);
       }*/
        speed = SmartDashboard.getNumber("The Forward Speed", SPEED);
        stoppingAngle = (int) (SmartDashboard.getNumber("The Angle", DEFAULT_ANGLE) * TICK_TO_ANGLE);
        DriverStationLCD d = DriverStationLCD.getInstance();
        //AUTON ONLY shrink power if too high
        if (DriverStation.getInstance().isAutonomous()) {
            double voltage = DriverStation.getInstance().getBatteryVoltage();
            final double tooMuchPower = 12.64;
            if (voltage > tooMuchPower) {
                speed -= 0.025;
            }
            d.println(DriverStationLCD.Line.kUser5, 1, "Auto volt: " + voltage);
            d.println(DriverStationLCD.Line.kUser6, 1, "Auto power: " + speed);
            d.updateLCD();
        }
        //System.out.println(speed);
        //System.out.println(stoppingAngle);
        timer.start();
        String log = "Time: " + DriverStation.getInstance().getMatchTime() + ", Voltage: " + DriverStation.getInstance().getBatteryVoltage() + ", power: " + speed;
        // System.out.println(log);
        d.println(DriverStationLCD.Line.kUser1, 1, "Time: " + DriverStation.getInstance().getMatchTime());
        d.println(DriverStationLCD.Line.kUser2, 1, "Voltage: " + DriverStation.getInstance().getBatteryVoltage());
        d.println(DriverStationLCD.Line.kUser3, 1, "Speed: " + speed);
        d.updateLCD();
        
    }

    /**
     * TODO: Document this.
     */
    protected void execute() {
        double position = catapult.getAngle();
        double time = timer.get();
        
        if(time > oldTime && position > oldPosition){
            double velocity = (position - oldPosition)/(time - oldTime);
            if(velocity > maxVelocity){
                maxVelocity = velocity;
            }
            //System.out.println("Velocity/time: " + velocity*ANGLETOTICK);
            oldPosition = position;
            oldTime = time;
        }
        
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
        DriverStationLCD d = DriverStationLCD.getInstance();
        d.println(DriverStationLCD.Line.kUser4, 1, "Velocity: " + maxVelocity);
        d.updateLCD();
        System.out.println("Encoder End Value:" + catapult.getAngle());
        
    }

    /**
     * TODO: Document this.
     */
    protected void interrupted() {
    }
}
