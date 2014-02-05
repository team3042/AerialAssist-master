package org.team3042.AerialAssist.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.team3042.AerialAssist.OI;
import org.team3042.AerialAssist.subsystems.CatapultSystem;
import org.team3042.AerialAssist.subsystems.CompressorSystem;
import org.team3042.AerialAssist.subsystems.DriveTrainSystemGearShift;
import org.team3042.AerialAssist.subsystems.DriveTrainSystem;
import org.team3042.AerialAssist.subsystems.IntakeSystemMotor;
import org.team3042.AerialAssist.subsystems.IntakeSystemPistons;
import org.team3042.AerialAssist.subsystems.RangeFinderSystem;

/**
 *
 *
 * @author Team 3042
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static final CompressorSystem compressorSystem = new CompressorSystem();
    public static final IntakeSystemMotor intake = new IntakeSystemMotor();
    public static final IntakeSystemPistons intakePiston = new IntakeSystemPistons();
    public static final DriveTrainSystem driveTrain = new DriveTrainSystem();
    public static final CatapultSystem catapult = new CatapultSystem();
    public static final DriveTrainSystemGearShift shiftGears = new DriveTrainSystemGearShift();
    public static final RangeFinderSystem rangeFinder = new RangeFinderSystem();

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
        SmartDashboard.putData(driveTrain);
        SmartDashboard.putData(catapult);
        SmartDashboard.putData(rangeFinder);

    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
