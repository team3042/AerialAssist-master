/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team3042.AerialAssist.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team3042.AerialAssist.RobotMap;
import org.team3042.AerialAssist.commands.Drive;

/**
 *
 * @author t0211801v
 */
public class DriveTrain extends Subsystem {
    RobotDrive drive = new RobotDrive (RobotMap.leftJag, RobotMap.rightJag, 
            RobotMap.leftJag1, RobotMap.rightJag1);
    Jaguar leftJag = new Jaguar(RobotMap.leftJag);
    Jaguar rightJag = new Jaguar(RobotMap.rightJag);
    Jaguar leftJag1 = new Jaguar(RobotMap.leftJag1);
    Jaguar rightJag1 = new Jaguar(RobotMap.rightJag1);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        setDefaultCommand(new Drive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void tankDrive(double left, double right){
        drive.tankDrive(left, right);
        
    }
}
