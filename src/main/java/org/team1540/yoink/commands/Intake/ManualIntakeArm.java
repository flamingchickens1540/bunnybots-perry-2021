package org.team1540.yoink.commands.Intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.GenericHID;

public class ManualIntakeArm extends SubsystemBase {
    private final XboxController copilot;
    public final TalonSRX intakeArm = new TalonSRX(2);
    public final TalonSRX intakeArm1 = new TalonSRX(1);
    public final TalonSRX[] motors = { intakeArm, intakeArm1 };

    public ManualIntakeArm(XboxController copilot) {
        this.copilot = copilot;

        for (TalonSRX motor : motors) {
            motor.setInverted(false);

            motor.configForwardSoftLimitEnable(false);
            motor.configReverseSoftLimitEnable(false);

            motor.configPeakCurrentLimit(5);
            motor.configPeakCurrentDuration(500);

            motor.setNeutralMode(NeutralMode.Brake);

        }
        intakeArm1.follow(intakeArm);

    }

    public void zeroRotation() {
        intakeArm.setSelectedSensorPosition(0);
    }

    public double getDegrees() {
        return intakeArm.getSelectedSensorPosition() / (4096 / 180);
    }

    public boolean softLimit(double percent) {
        return ((this.getDegrees() > 360 && percent >= 0) || (this.getDegrees() < 360 && percent <= 0));
    }

    public void disableMotors() {
        intakeArm.set(ControlMode.PercentOutput, 0);
    }

    public void enableMotorsUp(){
        intakeArm.set(ControlMode.PercentOutput, -0.5);
    }
    public void enableMotorsDown(){
        intakeArm.set(ControlMode.PercentOutput, 0.25);

    }

    public Command commandStop() {
        return new InstantCommand(this::disableMotors, this);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("arm/pos", getDegrees());

        double armPos = intakeArm.getSelectedSensorPosition();
        double armStick = copilot.getY(GenericHID.Hand.kLeft);

        SmartDashboard.putNumber("arm/encoder", armPos);
        SmartDashboard.putNumber("arm/stick", armStick);
        SmartDashboard.putNumber("arm/current", intakeArm.getStatorCurrent());

        if (armStick < 0 && armPos <= 1500) {
            intakeArm.set(ControlMode.PercentOutput, armStick/2);
        } else if (armStick > 0 && armPos >= -10) {
            intakeArm.set(ControlMode.PercentOutput, armStick/2);
        } else {
            intakeArm.set(ControlMode.PercentOutput, 0.0);
        }

    }
}
