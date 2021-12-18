package org.team1540.yoink.commands.Intake;

import edu.wpi.first.wpilibj.command.Command;

public class OuttakeBalls extends Command {
    private IntakeAndOuttake intake;

    public OuttakeBalls(IntakeAndOuttake intake) {
        this.intake = intake;
        // addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.set(-0.5);
    }

    @Override
    public boolean isFinished() {
        intake.disableMotors();
        return true;
    }
}
