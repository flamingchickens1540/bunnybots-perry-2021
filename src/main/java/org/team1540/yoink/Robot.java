package org.team1540.yoink;

import org.team1540.yoink.commands.DriveTrain.TankDrive;
import org.team1540.yoink.commands.Intake.IntakeAndOuttake;
import org.team1540.yoink.commands.Intake.ManualIntakeArm;
import org.team1540.yoink.commands.Intake.OuttakeForAuto;
import org.team1540.yoink.commands.DriveTrain.AvianDrive;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
    private final XboxController driver = new XboxController(0);
    private final XboxController copilot = new XboxController(1);

    TankDrive driveTrain = new TankDrive(NeutralMode.Brake, driver);
    IntakeAndOuttake intakeAndOuttake = new IntakeAndOuttake(copilot);
    ManualIntakeArm manualIntakeArm = new ManualIntakeArm(copilot);
    AvianDrive avianDrive = new AvianDrive(driveTrain, manualIntakeArm, intakeAndOuttake);

    // OuttakeForAuto auto = new OuttakeForAuto(intakeAndOuttake, manualIntakeArm);

    @Override
    public void robotInit() {
    }

    @Override
    public void teleopPeriodic() {
        manualIntakeArm.zeroRotation();
        driveTrain.periodic();
        intakeAndOuttake.periodic();
        manualIntakeArm.periodic();
    }

    @Override
    public void autonomousPeriodic() {
        // outtakeForAuto.schedule();
        avianDrive.execute();
    }

    @Override
    public void teleopInit() {
        // new JoystickButton(driver, Button.kA.value).whenActive();
    }

    @Override
    public void autonomousInit() {
    }

    @Override
    public void testInit() {
    }

    @Override
    public void testPeriodic() {
    }

    @Override
    public void disabledInit() {
    }
}
