package frc.robot.Commands.DriveTrain;

import edu.wpi.first.wpilibj.XboxController;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class IntakeAndOuttake{
    private final XboxController xboxController = new XboxController(0); 
    public TalonSRX shooterMotorA = new TalonSRX(8);
    public void intakeAndOuttake(){
        if (xboxController.getBButton()) {
          shooterMotorA.set(ControlMode.PercentOutput, 0.5);
        } 
        else if (xboxController.getAButton()) {
            shooterMotorA.set(ControlMode.PercentOutput, -0.5);
          }
        if(!xboxController.getBButton() && !xboxController.getAButton()){
            shooterMotorA.set(ControlMode.PercentOutput, 0);     
        }      
       }    
}
