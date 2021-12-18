package org.team1540.yoink.commands.Intake;

import edu.wpi.first.wpilibj.command.WaitCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class OuttakeForAuto extends CommandGroup {
    public OuttakeForAuto(IntakeAndOuttake intakeAndOuttake, ManualIntakeArm manualIntakeArm) {
        addSequential(new IntakeDown(manualIntakeArm));
        // addSequential(new InstantCommand(() -> {System.out.println("waiting");}));
        addSequential(new WaitCommand(0.25));
        addSequential(new OuttakeBalls(intakeAndOuttake));
        // addSequential(manualIntakeArm.commandStop());
    }
}
