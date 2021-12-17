package org.team1540.yoink;
/*// Copyright (c) FIRST and other WPILib contributors.
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
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.util.Units;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.EncoderType;

import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.revrobotics.CANSparkMax.IdleMode;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

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
//public class TestRobot extends TimedRobot {
  // Creates an encoder on DIO ports 0 and 1
//Encoder encoder = new Encoder(0, 1, false, EncodingType.k4X);

//private final double kDriveTick2Feet = 1.0/128 * 6 * Math.PI / 12; 

// Initialize motor controllers and drive
/*Spark left1 = new Spark(0);
Spark left2 = new Spark(1);

Spark right1 = new Spark(2);
Spark right2 = new Spark(3);
*/ 

//SpeedControllerGroup leftMotors = new SpeedControllerGroup(left1, left2);
//SpeedControllerGroup rightMotors = new SpeedControllerGroup(right1, right2);

//DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);


  /*private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  */
  //private final XboxController xboxController = new XboxController(0); 
  /*
  private TalonSRX driveMotorLeftA = new TalonSRX(1);
  private TalonSRX driveMotorLeftB = new TalonSRX(2);
  private TalonSRX driveMotorRightA = new TalonSRX(3);
  private TalonSRX driveMotorRightB = new TalonSRX(4);
  */
  //public TalonSRX shooterMotorA = new TalonSRX(7);
  
  //public TalonFX shooterMotorB = new TalonFX(10);
  //private TalonSRX indexer = new TalonSRX(8); 
  //private CANSparkMax funnelRightMotor = new CANSparkMax(7, CANSparkMaxLowLevel.MotorType.kBrushless);
  //private CANSparkMax rollerMotorA = new CANSparkMax(5, CANSparkMaxLowLevel.MotorType.kBrushless);
  
 /* private final TalonSRX driveMotors[]       = { driveMotorLeftA, driveMotorLeftB, driveMotorRightA, driveMotorRightB };
  private final TalonSRX leftDriveMotors[]   = { driveMotorRightB, driveMotorLeftB };
  private final TalonSRX rightDriveMotors[]  = { driveMotorRightA, driveMotorLeftA };
  */ 

  
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  //@Override
  //public void robotInit() {
    /// Drive Motor configuration
        // Set configuration for all motors
        /*for (TalonSRX motor : driveMotors) {
          motor.configFactoryDefault();
          motor.setNeutralMode(NeutralMode.Coast);
      }
      // Set configuration for left motors
      for (TalonSRX motor: leftDriveMotors) {
          motor.setInverted(true);
      }
      // Set configuration for right motors
      for (TalonSRX motor: rightDriveMotors) {
          motor.setInverted(false);
      }
      // Make rear motors follow front motors
      driveMotorRightA.follow(driveMotorRightB);
      driveMotorLeftA.follow(driveMotorLeftB);
      */ 
      ///
      
      /// Intake Roller configuration        
      
      /*rollerMotorA.restoreFactoryDefaults();
      rollerMotorA.setIdleMode(IdleMode.kCoast);

      rollerMotorA.setInverted(false);
      */ 

      ///


      //indexer.setInverted(true);

      //shooterMotorA.setInverted(false);
      //shooterMotorB.setInverted(true);
      
      //shooterMotorB.follow(shooterMotorA);


      // Resets the encoder to read a distance of zero
      //encoder.reset();
      // Configures the encoder's distance-per-pulse
     // The robot moves forward 1 foot per encoder rotation
     // There are 256 pulses per encoder rotation
     //encoder.setDistancePerPulse(1/256);


    //}

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

     

   /*   //Setting up buttons for tele
  XboxController driverController = new XboxController(0);
  public double getDriverAxis(int axis){
    return driverController.getRawAxis(axis); 
  }

  @Override
  public void robotPeriodic() {
    // position time graph displayed on dashboard 
    //SmartDashboard.putNumber("encoderValue", encoder.get()* kDriveTick2Feet); 
  }

  @Override
  public void teleopInit() {
    // TODO Auto-generated method stub
    super.teleopInit();
  }

  /** This function is called periodically during operator control. */
 // @Override
  /*public void teleopPeriodic() {
    tankDrive();
    shooterAndIndexer();
    //rollerMotor();
    //limeLight(); 
    //absoluteEncoder();
  }

  final double kP = 0.05; 

  double setpoint = 0; 

  @Override
  public void autonomousPeriodic(){
    //get joystick command 
    /*if(xboxController.getRawButton(1)){
      setpoint = 10; //how far you want to go in feet 
    }
    else if (xboxController.getRawButton(2)){
      setpoint = 0; 
    }
    */ 

    //get sensor position 
    //double sensorPosition = encoder.get()*kDriveTick2Feet; 

    //calculations 
    //double error = setpoint - sensorPosition; 

    //double outputSpeed = kP * error; 

    //output calculated speed to motors
    //driveMotorRightA.set(ControlMode.PercentOutput, outputSpeed);
    //driveMotorRightB.set(ControlMode.PercentOutput, outputSpeed);
    //driveMotorLeftA.set(ControlMode.PercentOutput, -outputSpeed);
    //driveMotorLeftB.set(ControlMode.PercentOutput, -outputSpeed);


  //}

  
 /* public void tankDrive(){
    double leftY = xboxController.getY(GenericHID.Hand.kLeft); 
    double rightY = xboxController.getY(GenericHID.Hand.kRight); 
    if(leftY >= -0.1 && leftY <= 0.1){ //dead zone 
      leftY =0; 
    }
    if(rightY >= -0.1 && rightY <= 0.1){ //dead zone 
      rightY =0; 
    }
    //driveMotorRightA.set(ControlMode.PercentOutput, leftY * -1);//setting speed of motors
    //driveMotorLeftA.set(ControlMode.PercentOutput, rightY);   
    

  }

  /*public void shooterAndIndexer(){
    if (xboxController.getBButton()) {
      shooterMotorA.set(ControlMode.PercentOutput, 0.5);
      //indexer.set(ControlMode.PercentOutput, 0.5);
    } else {
      shooterMotorA.set(ControlMode.PercentOutput, 0);
      //indexer.set(ControlMode.PercentOutput, 0);
    } 
  }

  /*public void rollerMotor(){
    if (xboxController.getAButton()) {
      //funnelRightMotor.set(0.5);
      rollerMotorA.set(0.5);
    }   else {
      //funnelRightMotor.set(0.0);
      rollerMotorA.set(0.0);
    } 
  }
  */
  
  //lime light stuff: 
  /*public void limeLight(){ 
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
    */ 

 /* public void absoluteEncoder(){
    // Initializes an encoder on DIO pins 0 and 1
    // Defaults to 4X decoding and non-inverted
   //Encoder encoder = new Encoder(0, 1);
   // Configures the encoder to return a distance of 4 for every 256 pulses
   // Also changes the units of getRate
   encoder.setDistancePerPulse(4./256.);

   // Configures the encoder to consider itself stopped after .1 seconds
   encoder.setMaxPeriod(.1);

   // Configures the encoder to consider itself stopped when its rate is below 10
   encoder.setMinRate(10);

   // Reverses the direction of the encoder
   encoder.setReverseDirection(true);

   // Configures an encoder to average its period measurement over 5 samples
   // Can be between 1 and 127 samples
   encoder.setSamplesToAverage(5);
   // Gets the distance traveled
   encoder.getDistance();
  // Gets whether the encoder is stopped
   encoder.getStopped();
   // Gets the last direction in which the encoder moved
   encoder.getDirection();
   // Gets the current period of the encoder
   encoder.getPeriod();
   


   // Drives forward at half speed until the robot has moved 5 feet, then stops:
   if(encoder.getDistance() < 5) {
    drive.tankDrive(.5, .5);
   } else {
    drive.tankDrive(0, 0);
   
   }
   

}
  
 */ 



