/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team3042.AerialAssist.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Robotics
 */
public class CameraUpdater extends CommandBase {

    public CameraUpdater() {
        requires(camera);
        setRunWhenDisabled(true); // We want the camera to have a status ready for auton
    }
    private long started = 0;

    // Called just before this Command runs the first time
    protected void initialize() {
        //We offset it so that the camera updates soon after robot is on    
        started = System.currentTimeMillis() - (17 * 1000);
        //CMB - What? Why the math? 
        // So that the loop below happens after three seconds instead of 20?
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //If the last time we updated is > 20 seconds ago
        if (System.currentTimeMillis() - started > 20 * 1000) {
            camera.update();
            // CMB - What exactly does camera.update() update?
            // CMB - Only get a picture every 20 seconds? 
            // Or once after 3 secords then every 20?
            // Don't you miss this if it is not hot initally?
            started = System.currentTimeMillis();
        }
        SmartDashboard.putBoolean("Is goal hot", camera.isHot());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
