// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.feederDrumJoystick;
import frc.robot.commands.shooterSpeedJoystick;
import frc.robot.commands.tankDrive;
import frc.robot.commands.Autonomous.DriveTurn;
import frc.robot.commands.Autonomous.Turn90;
import frc.robot.commands.Autonomous.barrelRacingPath;
import frc.robot.commands.Autonomous.driveDistance;
import frc.robot.commands.Autonomous.driveForward;
import frc.robot.commands.Autonomous.encoderTurn90;
import frc.robot.commands.Autonomous.encoderTurn90Left;
import frc.robot.commands.Autonomous.slalomPath;
import frc.robot.commands.Autonomous.timerTurn90Left;
import frc.robot.commands.Autonomous.timerTurn90Right;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.FeederDrum;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.navX;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  public static final DriveTrain m_driveTrain = new DriveTrain();
  public static final Command m_driveForward = new driveForward(60);
  public static final navX m_navx = new navX();
  public static final Command m_driveTurn = new DriveTurn();
  //public static final Command m_driveReverse = new driveReverse(24);
  public static final Command m_timerTurn90Right = new timerTurn90Right();
  public static final Command m_timerTurn90Left = new timerTurn90Left();
  public static final Command m_barrelRacingPath = new barrelRacingPath(m_driveTrain);
  public static final Command m_encoderTurn90Left = new encoderTurn90Left();
  public static final Command m_driveDistance = new driveDistance(-.3, 60);
  public static final Command m_encoderTurn90 = new encoderTurn90(-.3, .3, 9.75);
  public static final Command m_slalomPath = new slalomPath();
  public static final FeederDrum m_feederDrum = new FeederDrum();
  public static final Shooter m_shooter = new Shooter();
  public static final Intake m_intake = new Intake();
  public static final  Joystick logitechController = new Joystick(3);
  
   
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_driveTrain.setDefaultCommand(new tankDrive());
    //m_shooter.setDefaultCommand(new shooterSpeedJoystick());
    m_feederDrum.setDefaultCommand(new feederDrumJoystick());
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    
   new JoystickButton(logitechController, 5).whenPressed(()-> RobotContainer.m_feederDrum.drumMotor.set(ControlMode.PercentOutput, .3))
   .whenReleased(()-> RobotContainer.m_feederDrum.drumMotor.set(ControlMode.PercentOutput, 0));
  
   //This controls our shooter speed
   //The button sets the method in the shooter subsystem to an int between 1 - 4. This then tells the method which if statement to call. This sets the speed.
   // "->" seperates the parameters from implementation (this is a lamba thingy), so basically is seperates the parameters of the whenPressed method from the implemenation of the command method?
   new JoystickButton(logitechController, 1).whenPressed(()-> RobotContainer.m_shooter.setShooterSpeed(1))
   .whenReleased(()-> RobotContainer.m_shooter.topAndBottomShooterMotor.set(0));

   new JoystickButton(logitechController, 2).whenPressed(()-> RobotContainer.m_shooter.setShooterSpeed(2))
  .whenReleased(()-> RobotContainer.m_shooter.topAndBottomShooterMotor.set(0));

   new JoystickButton(logitechController, 3).whenPressed(()-> RobotContainer.m_shooter.setShooterSpeed(3))
   .whenReleased(()-> RobotContainer.m_shooter.topAndBottomShooterMotor.set(0));

   new JoystickButton(logitechController, 4).whenPressed(()-> RobotContainer.m_shooter.setShooterSpeed(4))
   .whenReleased(()-> RobotContainer.m_shooter.topAndBottomShooterMotor.set(0));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_slalomPath;
  
  }
}
