package frc.robot.Commands.DriveTrain;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.TimedRobot;

public class TankDrive extends TimedRobot{
  private TalonSRX driveMotorLeftA = new TalonSRX(5);
  private TalonSRX driveMotorLeftB = new TalonSRX(6);
  private TalonSRX driveMotorRightA = new TalonSRX(3);
  private TalonSRX driveMotorRightB = new TalonSRX(4);
  private final XboxController xboxController = new XboxController(0); 

  @Override
  public void robotInit() {
    driveMotorRightA.follow(driveMotorRightB);
    driveMotorLeftA.follow(driveMotorLeftB);
  }
  public void tankDrive(){
    double leftY = xboxController.getY(GenericHID.Hand.kLeft); 
    double rightY = xboxController.getY(GenericHID.Hand.kRight); 
   if(leftY >= -0.1 && leftY <= 0.1){ //dead zone 
     leftY =0; 
   }
   if(rightY >= -0.1 && rightY <= 0.1){ //dead zone 
     rightY =0; 
   }
   driveMotorRightA.set(ControlMode.PercentOutput, rightY*-1);//setting speed of motors
   driveMotorRightB.set(ControlMode.PercentOutput, rightY*-1);
   driveMotorLeftA.set(ControlMode.PercentOutput, leftY); 
   driveMotorLeftB.set(ControlMode.PercentOutput, leftY);
   }
}
