package org.team1540.yoink.commands.DriveTrain;

import org.team1540.yoink.commands.Intake.ManualIntakeArm;
import org.team1540.yoink.commands.Intake.IntakeAndOuttake;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class AvianDrive extends CommandBase {

    private final TankDrive driveTrain; 
    private final ManualIntakeArm manualIntakeArm;
    private final IntakeAndOuttake intakeAndOuttake; 

    public AvianDrive(TankDrive drivetrain, ManualIntakeArm manualIntakeArm, IntakeAndOuttake intakeAndOuttake) {
        addRequirements(drivetrain);

        this.driveTrain = drivetrain;
        this.manualIntakeArm = manualIntakeArm; 
        this.intakeAndOuttake = intakeAndOuttake; 

        manualIntakeArm.zeroRotation();
    }

    @Override
    public void execute() {
        if (SmartDashboard.getNumber("avian/detected_hands", 0) < 2) {
            driveTrain.disableMotors();
        }

        driveTrain.setPercent(
            -SmartDashboard.getNumber("avian/left_tank", 0),
            -SmartDashboard.getNumber("avian/right_tank", 0)
        );

        // Arm
        if (SmartDashboard.getBoolean("avian/left_pinch", false)) {
            manualIntakeArm.enableMotorsUp();
        } else if (SmartDashboard.getBoolean("avian/right_pinch", false)) {
            manualIntakeArm.enableMotorsDown();
        } else {
            manualIntakeArm.disableMotors();
        }

        // Intake
        if (SmartDashboard.getBoolean("avian/left_middle_finger", false)) {
            intakeAndOuttake.intakeMotors();
        } else if (SmartDashboard.getBoolean("avian/right_middle_finger", false)) {
            intakeAndOuttake.outtakeMotors();
        } else {
            intakeAndOuttake.disableMotors();
        }
    }
}
    

