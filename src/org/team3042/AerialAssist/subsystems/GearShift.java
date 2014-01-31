/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.team3042.AerialAssist.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.team3042.AerialAssist.RobotMap;
//import edu.wpi.first.wpilibj.Jaguar;
//import org.team3042.joystickDT.RobotMap;
import org.team3042.AerialAssist.commands.ShiftGears;
//import edu.wpi.first.wpilibj.Relay;
//import org.team3042.joystickDT.OI;
//import edu.wpi.first.wpilibj.PWM;

/**
 *
 * @author noah G
 */
public class GearShift extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    Relay shiftSpike = new Relay(RobotMap.SHIFT_SPIKE );
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ShiftGears(false));
    }
    public void shiftHigh (){
        shiftSpike.set(Relay.Value.kReverse);
    }
    public void shiftLow() {
        shiftSpike.set(Relay.Value.kOff);
    }
}

