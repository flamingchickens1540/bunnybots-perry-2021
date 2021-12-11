package frc.robot.Commands.DriveTrain;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.TimedRobot;

public class IntakeArm {
    public TalonSRX intakeArm = new TalonSRX(2); 
    private final XboxController xboxController1 = new XboxController(1); 
    public void intakeArm(){
        double arm = xboxController1.getY(GenericHID.Hand.kLeft); 
        intakeArm.set(ControlMode.PercentOutput, arm);
      }
}
