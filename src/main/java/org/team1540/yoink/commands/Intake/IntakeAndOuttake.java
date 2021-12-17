package org.team1540.yoink.commands.Intake;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class IntakeAndOuttake extends SubsystemBase {
  private final XboxController copilot;
  public TalonSRX shooterMotorA = new TalonSRX(7);

  public IntakeAndOuttake(XboxController copilot) {
    this.copilot = copilot;
  }

  @Override
  public void periodic() {
    if (copilot.getBButton()) {
      shooterMotorA.set(ControlMode.PercentOutput, 0.5);
    } else if (copilot.getAButton()) {
      shooterMotorA.set(ControlMode.PercentOutput, -0.5);
    }
    if (!copilot.getBButton() && !copilot.getAButton()) {
      shooterMotorA.set(ControlMode.PercentOutput, 0);
    }
  }
}
