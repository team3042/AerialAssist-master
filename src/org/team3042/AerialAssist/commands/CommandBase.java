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
    
    public static final CompressorSystem COMPRESSOR_SYSTEM = new CompressorSystem();
    public static final IntakeSystemMotor INTAKE = new IntakeSystemMotor();
    public static final IntakeSystemPistons INTAKE_PISTON = new IntakeSystemPistons();
    public static final DriveTrainSystem DRIVE_TRAIN = new DriveTrainSystem();
    public static final CatapultSystem CATAPULT_SYSTEM = new CatapultSystem();
    public static final DriveTrainSystemGearShift SHIFT_GEARS = new DriveTrainSystemGearShift();
    public static final RangeFinderSystem RANGE_FINDER = new RangeFinderSystem();

    /**
     * Instantiates an {@link OI}, and puts Subsystems on the {@link SmartDashboard}.
     */
    public static void init() {
        oi = new OI();

        SmartDashboard.putData(COMPRESSOR_SYSTEM);
        SmartDashboard.putData(INTAKE);
        SmartDashboard.putData(INTAKE_PISTON);
        SmartDashboard.putData(DRIVE_TRAIN);
        SmartDashboard.putData(CATAPULT_SYSTEM);
        SmartDashboard.putData(RANGE_FINDER);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
