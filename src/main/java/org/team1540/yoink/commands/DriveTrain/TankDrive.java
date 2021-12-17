package org.team1540.yoink.commands.DriveTrain; 

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.GenericHID;
import com.ctre.phoenix.motorcontrol.NeutralMode;



public class TankDrive extends SubsystemBase{
  private TalonSRX driveMotorLeftA = new TalonSRX(5);
  private TalonSRX driveMotorLeftB = new TalonSRX(4);
  private TalonSRX driveMotorRightA = new TalonSRX(3);
  private TalonSRX driveMotorRightB = new TalonSRX(6);
  private final XboxController driver = new XboxController(0); 

  public TankDrive(NeutralMode brakeType, XboxController driver){
    initMotors(brakeType);
  }

  public void initMotors(NeutralMode brakeType) {
    driveMotorRightA.follow(driveMotorRightB);
    driveMotorLeftA.follow(driveMotorLeftB);

    driveMotorRightA.setInverted(false);
    driveMotorRightB.setInverted(false);
    driveMotorLeftA.setInverted(true);
    driveMotorLeftB.setInverted(true);
  }

  @Override
  public void periodic(){
    double leftY = driver.getY(GenericHID.Hand.kLeft); 
    double rightY = driver.getY(GenericHID.Hand.kRight); 
   if(leftY >= -0.1 && leftY <= 0.1){ //dead zone 
     leftY =0; 
   }
   if(rightY >= -0.1 && rightY <= 0.1){ //dead zone 
     rightY =0; 
   }

   driveMotorRightA.set(ControlMode.PercentOutput, rightY);//setting speed of motors
   driveMotorRightB.set(ControlMode.PercentOutput, rightY);
   driveMotorLeftA.set(ControlMode.PercentOutput, leftY); 
   driveMotorLeftB.set(ControlMode.PercentOutput, leftY);
   }

   public void setPercent(double leftPercent, double rightPercent) {
    driveMotorLeftA.set(ControlMode.PercentOutput, leftPercent);
    driveMotorRightA.set(ControlMode.PercentOutput, rightPercent);
   } 
   public void disableMotors() {
    driveMotorLeftA.set(ControlMode.PercentOutput, 0);
    driveMotorRightA.set(ControlMode.PercentOutput, 0);
}
}
