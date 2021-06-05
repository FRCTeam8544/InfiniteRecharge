// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AutoDriveCommands.BarrelRacingPath;
import frc.robot.commands.AutoDriveCommands.BouncePath;
import frc.robot.commands.AutoDriveCommands.DriveDistance;
import frc.robot.commands.AutoDriveCommands.SlalomPath;
import frc.robot.commands.DrumCommands.DrumPulse;
import frc.robot.commands.DrumCommands.DrumSpeed;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.TankDrive;
import frc.robot.commands.AutoDriveCommands.TurnAngle90;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Drum;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  //all of my subsystems are defined here 
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveTrain m_driveTrain = new DriveTrain();
  private final Drum m_drum = new Drum();
  private final IntakeArm m_intakeArm = new IntakeArm();
  private final Shooter m_shooter = new Shooter();

  //my commands are defined here 
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  //drum commands
  private final Command m_drumPulse = new DrumPulse(m_drum);
  private final Command m_drumSpeed = new DrumSpeed(m_drum);
  //auto commands
  private final Command m_barrelRacingPath = new BarrelRacingPath();
  private final Command m_bouncePath = new BouncePath();
  private final Command m_slalomPath = new SlalomPath();
  private final Command m_driveDistance = new DriveDistance(m_driveTrain, 0, 0);
  private final Command m_turnAngle90 = new TurnAngle90(m_driveTrain, 0, 0, 0);
  // tank drive 
  private final Command m_tankDrive = new TankDrive(m_driveTrain);

  //these are my joysticks --> define buttons under the configure button bindings
  //@should this be private??
  public static final Joystick leftDriveController = new Joystick(Constants.ROBOTCONTAINER_LEFT_DRIVE_CONTROLLER_PORT);
  public static final Joystick rightDriveController = new Joystick(Constants.ROBOTCONTAINER_RIGHT_DRIVE_CONTROLLER_PORT);
  public static final Joystick HIDController = new Joystick(Constants.ROBOTCONTAINER_HID_CONTROLLER_PORT);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    //default commands for subsystems
    m_driveTrain.setDefaultCommand(m_tankDrive);
    m_drum.setDefaultCommand(m_drumSpeed);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  //shooter wheel buttons --> each button has a pressed which turns it on and a released which turns it off (stop shooter method is in shooter subsystem)
  //each color corresponds to specific button on controller (I could also use letters but colors were easier to see from distance and easier to recognize right away)
  new JoystickButton(HIDController, Constants.ROBOTCONTAINER_BUTTON_NUMBER_B)
  .whenPressed(() -> m_shooter.setShooterSpeed("red"))
  .whenReleased(() -> m_shooter.stopShooter());

  new JoystickButton(HIDController, Constants.ROBOTCONTAINER_BUTTON_NUMBER_X)
  .whenPressed(() -> m_shooter.setShooterSpeed("blue"))
  .whenReleased(() -> m_shooter.stopShooter());

  new JoystickButton(HIDController, Constants.ROBOTCONTAINER_BUTTON_NUMBER_Y)
  .whenPressed(() -> m_shooter.setShooterSpeed("yellow"))
  .whenReleased(() -> m_shooter.stopShooter());

  new JoystickButton(HIDController, Constants.ROBOTCONTAINER_BUTTON_NUMBER_A)
  .whenPressed(() -> m_shooter.setShooterSpeed("green"))
  .whenReleased(() -> m_shooter.stopShooter());

  //drum motor pulse --> drum turns on for 1 sec and then stops and then turns on for 1 sec and off thus creating pulse 
  new JoystickButton(HIDController, Constants.ROBOTCONTAINER_BUTTON_LEFT_THUMB)
  .whenPressed(new SequentialCommandGroup(new DrumPulse(m_drum), new WaitCommand(.5),new DrumPulse(m_drum), new WaitCommand(.5), new DrumPulse(m_drum), new WaitCommand(.5)));

  //setting intake arm speed --> command sets speed and tests for limit switch states --> look at intakearm subsystem for command specifics 
  //up for arm 
  new JoystickButton(HIDController, Constants.ROBOTCONTAINER_BUTTON_RIGHT_TRIGGER)
  .whileHeld(()-> m_intakeArm.setArmMotorSpeed(.1))
  .whenReleased(()-> m_intakeArm.stopArmMotor());
  //down for arm 
  new JoystickButton(HIDController, Constants.ROBOTCONTAINER_BUTTON_LEFT_TRIGGER)
  .whileHeld(()-> m_intakeArm.setArmMotorSpeed(-.1))
  .whenReleased(()-> m_intakeArm.stopArmMotor());
}



  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
