/*package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.XboxController;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.ButtonType;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Commands.DriveTrain.TankDrive;


public class RobotContainer {

    public final XboxController driverController = new XboxController(0);
    public final Joystick copilotJoystick = new Joystick(1);

    public final AHRS navx = new AHRS(SPI.Port.kMXP);

    public final TankDrive driveTrain = new TankDrive(NeutralMode.Brake);

    private boolean shootConfirmation;

    public RobotContainer() {
        // Configure the button bindings\

        
        initSmartDashboard();

    }


    private void initSmartDashboard() {
        SmartDashboard.putNumber("turret/speedMinimum", SmartDashboard.getNumber("turret/speedMinimum", 0.1));
        SmartDashboard.putNumber("turret/disableButton", SmartDashboard.getNumber("turret/disableButton", 2));
        // SmartDashboard.putBoolean("turret/shootConfirmation", SmartDashboard.getBoolean("turret/shootConfirmation", true));
        SmartDashboard.setDefaultBoolean("turret/shootConfirmation", true);
    }
    
}
*/