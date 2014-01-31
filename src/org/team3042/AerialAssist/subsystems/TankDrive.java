/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team3042.AerialAssist.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team3042.AerialAssist.RobotMap;
import org.team3042.AerialAssist.commands.TDrive;





/**
 *
 * @author noah G
 */
public class TankDrive extends Subsystem {
    Jaguar rightMotor = new Jaguar(RobotMap.RIGHT_MOTOR);
    Jaguar leftMotor = new Jaguar (RobotMap.LEFT_MOTOR);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TDrive());
    }
    
    public void Drive(double leftSpeed,double rightSpeed){
        if (leftSpeed>1) leftSpeed = 1.0;
        if (rightSpeed>1) rightSpeed = 1.0;
        if (leftSpeed<-1) leftSpeed = -1.0;
        if (rightSpeed<-1) rightSpeed = -1.0;
        leftMotor.set(leftSpeed);
        rightMotor.set(-rightSpeed);       
    }
    
}
