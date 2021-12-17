package org.team1540.yoink.commands.Intake;
/*
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import org.team1540.yoink.MiniPID;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;;
*/
public class IntakeArm{ //extends SubsystemBase {
   /* public final TalonSRX intakeArm = new TalonSRX(2);
    public double currentRotation, baseRotation, degreesSetpoint;
    private MiniPID pidController = new MiniPID(0,0,0);
    public IntakeArm() {
        initMotors(NeutralMode.Coast);
    }
    public IntakeArm(NeutralMode brakeType) {
        initMotors(brakeType);
    }
    @Override
    public void periodic() {
        pidController.setPID(SmartDashboard.getNumber("arm/p", 0), 
                            SmartDashboard.getNumber("arm/i", 0),
                            SmartDashboard.getNumber("arm/d", 0));
    }
    private void initMotors(NeutralMode brakeType) {
        intakeArm.configFactoryDefault();
        intakeArm.setNeutralMode(brakeType);
        degreesSetpoint = 0;
    }
    public void rotate() {
        baseRotation = intakeArm.getSelectedSensorPosition(); 
        this.setDegrees(0);
    }
    /*public void dangerousSetPercent(double percent) {
        System.out.println(this.degreesSetpoint);
        double output = pidController.getOutput(this.getDegrees(), this.degreesSetpoint);
        System.out.println(output);
        if (Math.abs(output) > 0.5) {
            intakeArm.set(ControlMode.PercentOutput, 0.5);
        } else {
            intakeArm.set(ControlMode.PercentOutput, output);
        }
    }
    */ /*
    public void safeSetPercent(double percent) {
        dangerousSetPercent(percent);
    }
    public void setDegrees(double degrees) {
        System.out.println(degrees);
        double degreesSetpoint = this.getDegrees() + degrees;
        if (degreesSetpoint > 360) {
            degreesSetpoint = 360;
        } else if (degreesSetpoint < -360) {
            degreesSetpoint=-360;
        }
        this.degreesSetpoint = degreesSetpoint;
        dangerousSetPercent(0);
    }
    public void zeroRotation() {
        intakeArm.setSelectedSensorPosition(0);
    }
    public double getDegrees() {
        return intakeArm.getSelectedSensorPosition()/(4096/180);
    }
    public boolean checkSoftLimit(double percent) {
        return ((this.getDegrees() > 360 && percent >= 0) || (this.getDegrees() < 360 && percent <= 0));
    }
    public void disableMotors() {
        intakeArm.set(ControlMode.PercentOutput, 0);
    }
    public Command commandStop() {
        return new InstantCommand(this::disableMotors, this);
    }
}
/*import edu.wpi.first.wpilibj.XboxController;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.GenericHID;


public class IntakeArm {
    public TalonSRX intakeArm = new TalonSRX(2); 
    private final XboxController xboxController1 = new XboxController(1); 
    public void intakeArm(){
        double arm = xboxController1.getY(GenericHID.Hand.kLeft); 
        intakeArm.set(ControlMode.PercentOutput, arm);
      }
     
      
   */    
}

