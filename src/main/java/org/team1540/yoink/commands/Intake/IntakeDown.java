package org.team1540.yoink.commands.Intake;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeDown extends Command {
    private ManualIntakeArm intake;

    public IntakeDown(ManualIntakeArm intake) {
        this.intake = intake;
        // addRequirements(intake);
    }

    @Override
    public void initialize() {
        intake.enableMotorsDown();
    }

    @Override
    public boolean isFinished() {
        intake.disableMotors();
        return true;
    }
}
