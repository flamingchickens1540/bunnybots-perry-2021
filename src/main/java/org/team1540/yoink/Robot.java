package org.team1540.yoink;

import org.team1540.yoink.commands.DriveTrain.TankDrive;
import org.team1540.yoink.commands.Intake.IntakeAndOuttake;
import org.team1540.yoink.commands.Intake.ManualIntakeArm;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.TimedRobot;

import com.ctre.phoenix.motorcontrol.NeutralMode;


public class Robot extends TimedRobot{
    private final XboxController driver = new XboxController(0);

   private final XboxController copilot = new XboxController(1);

    TankDrive driveTrain = new TankDrive(NeutralMode.Brake, driver);
    IntakeAndOuttake intakkeAndOuttake = new IntakeAndOuttake(copilot); 
    ManualIntakeArm manualIntakeArm = new ManualIntakeArm(copilot); 

    @Override
    public void robotInit() {
        
    }

    @Override
    public void teleopPeriodic() {
        driveTrain.periodic();
        intakkeAndOuttake.periodic();
        manualIntakeArm.periodic(); 
    }

    @Override
    public void teleopInit() {
       
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
    public void disabledInit(){

    }
}
