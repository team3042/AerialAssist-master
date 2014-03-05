/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.team3042.AerialAssist;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team3042.AerialAssist.commands.AutoDriveShoot;
import org.team3042.AerialAssist.commands.CommandBase;
import org.team3042.AerialAssist.subsystems.RangeFinderSystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 *
 * @author Team 3042
 */
public class RobotTemplate extends IterativeRobot {

    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        SmartDashboard.putNumber("The Reverse Speed", .250);
        SmartDashboard.putNumber("The Forward Speed", 0.850);
        autonomousCommand = new AutoDriveShoot();
        // instantiate the command used for the autonomous period

        // Initialize all subsystems
        CommandBase.init();
        //Setup camera settings
        CommandBase.camera.autonCameraConfig();
    }

    public void autonomousInit() {

        // schedule the autonomous command (example)
        CommandBase.camera.autonCameraConfig();
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomousCommand.cancel();
        CommandBase.camera.teleopCameraConfig();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("The Range", RangeFinderSystem.getRange());
        SmartDashboard.putNumber("Battery Volatge", DriverStation.getInstance().getBatteryVoltage());
    }

    
    public void testInit() {
            System.out.println("### Is hot: " + CommandBase.camera.isHot());
    }
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        //LiveWindow.run();
    }
}
