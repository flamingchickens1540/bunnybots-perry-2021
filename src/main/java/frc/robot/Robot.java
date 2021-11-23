// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;




/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  private final XboxController xboxController = new XboxController(0); 
  private TalonFX driveMotorLeftA = new TalonFX(1);
  private TalonFX driveMotorLeftB = new TalonFX(2);
  private TalonFX driveMotorRightA = new TalonFX(3);
  private TalonFX driveMotorRightB = new TalonFX(4);
  public TalonFX shooterMotorA = new TalonFX(9);
  public TalonFX shooterMotorB = new TalonFX(10);
  private TalonFX indexer = new TalonFX(8); 
  //private CANSparkMax funnelRightMotor = new CANSparkMax(7, CANSparkMaxLowLevel.MotorType.kBrushless);
  private CANSparkMax rollerMotorA = new CANSparkMax(5, CANSparkMaxLowLevel.MotorType.kBrushless);
  
  private final TalonFX driveMotors[]       = { driveMotorLeftA, driveMotorLeftB, driveMotorRightA, driveMotorRightB };
  private final TalonFX leftDriveMotors[]   = { driveMotorRightB, driveMotorLeftB };
  private final TalonFX rightDriveMotors[]  = { driveMotorRightA, driveMotorLeftA };

  
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    /// Drive Motor configuration
        // Set configuration for all motors
        for (TalonFX motor : driveMotors) {
          motor.configFactoryDefault();
          motor.setNeutralMode(NeutralMode.Coast);
      }
      // Set configuration for left motors
      for (TalonFX motor: leftDriveMotors) {
          motor.setInverted(true);
      }
      // Set configuration for right motors
      for (TalonFX motor: rightDriveMotors) {
          motor.setInverted(false);
      }
      // Make rear motors follow front motors
      driveMotorRightA.follow(driveMotorRightB);
      driveMotorLeftA.follow(driveMotorLeftB);
      ///
      
      /// Intake Roller configuration        
      
      rollerMotorA.restoreFactoryDefaults();
      rollerMotorA.setIdleMode(IdleMode.kCoast);

      rollerMotorA.setInverted(false);

      ///


      indexer.setInverted(true);

      shooterMotorA.setInverted(false);
      shooterMotorB.setInverted(true);
      
      shooterMotorB.follow(shooterMotorA);


    }
      /*
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    driveMotorRightA.follow(driveMotorRightB);
    driveMotorLeftA.follow(driveMotorLeftB);
    shooterMotorB.setInverted(true);
    shooterMotorB.follow(shooterMotorA);
    indexer.setInverted(true);
    //double leftY = xboxController.getY(GenericHID.Hand.kLeft); 
    */

     

      //Setting up buttons for tele
  XboxController driverController = new XboxController(0);
  public double getDriverAxis(int axis){
    return driverController.getRawAxis(axis); 
  }


  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    tankDrive();
    shooterAndIndexer();
    rollerMotor();
    limeLight(); 

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
    driveMotorRightA.set(ControlMode.PercentOutput, leftY * -1);//setting speed of motors
    driveMotorLeftA.set(ControlMode.PercentOutput, rightY);   
    

  }

  public void shooterAndIndexer(){
    if (xboxController.getBButton()) {
      shooterMotorA.set(ControlMode.PercentOutput, 0.5);
      indexer.set(ControlMode.PercentOutput, 0.5);
    } else {
      shooterMotorA.set(ControlMode.PercentOutput, 0);
      indexer.set(ControlMode.PercentOutput, 0);
    } 
  }

  public void rollerMotor(){
    if (xboxController.getAButton()) {
      //funnelRightMotor.set(0.5);
      rollerMotorA.set(0.5);
    }   else {
      //funnelRightMotor.set(0.0);
      rollerMotorA.set(0.0);
    } 
  }
  
  //lime light stuff: 
  public void limeLight(){ 
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");
  
    //read values periodically
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double area = ta.getDouble(0.0);
  
    //post to smart dashboard periodically
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", area);
  
    }
  


}
