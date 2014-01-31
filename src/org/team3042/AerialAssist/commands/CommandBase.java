package org.team3042.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team3042.AerialAssist.OI;
import org.team3042.AerialAssist.subsystems.Catapult;
import org.team3042.AerialAssist.subsystems.IntakeMotor;
import org.team3042.AerialAssist.subsystems.IntakePistons;
import org.team3042.AerialAssist.subsystems.CompressorSystem;
import org.team3042.AerialAssist.subsystems.TankDrive;
import org.team3042.AerialAssist.subsystems.GearShift;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static CompressorSystem compressorSystem = new CompressorSystem();
public static IntakeMotor intake = new IntakeMotor();
public static IntakePistons intakePiston = new IntakePistons();
public static TankDrive tankDrive = new TankDrive();
public static Catapult  catapult = new Catapult ();
public static GearShift shiftGears = new GearShift();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
        

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(compressorSystem);
        SmartDashboard.putData(intake);
        SmartDashboard.putData(intakePiston);
        SmartDashboard.putData(tankDrive);
        SmartDashboard.putData(catapult);
        
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
