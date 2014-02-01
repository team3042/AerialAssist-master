/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team3042.AerialAssist.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team3042.AerialAssist.RobotMap;
import org.team3042.AerialAssist.commands.GetRange;
import org.team3042.AerialAssist.commands.CommandBase;

/**
 *
 * @author t0211801v
 */
public class RangeFinder extends Subsystem {
    private static final AnalogChannel rangeFinder = new AnalogChannel(RobotMap.rangeFinder);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public RangeFinder() {
        SmartDashboard.putNumber("The Range", getRange());
    }

    public void initDefaultCommand() {
        
        setDefaultCommand(new GetRange());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public static final double getRange(){
        return rangeFinder.getVoltage();
    }
}
