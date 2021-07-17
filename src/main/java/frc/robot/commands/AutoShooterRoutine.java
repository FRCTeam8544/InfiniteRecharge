// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.AutoDriveCommands.DriveDistance;
import frc.robot.commands.DrumCommands.AutoDrumSpeed;
import frc.robot.commands.ShooterCommands.AutoShooterSpeed;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Drum;
import frc.robot.subsystems.Shooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoShooterRoutine extends SequentialCommandGroup {
  /** Creates a new AutoShooterRoutine. */
  Drum m_Drum;
  Shooter m_Shooter;
  DriveTrain m_Drive;
  
  public AutoShooterRoutine(Drum drum, Shooter shooter, DriveTrain drive) {
    m_Drive = drive;
    m_Drum = drum;
    m_Shooter = shooter;
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new ParallelDeadlineGroup(new AutoShooterSpeed(m_Shooter, Constants.AUTO_PERCENT_POWER_SHOOTER_WHEELS, Constants.AUTO_SHOOTER_RUNTIME), 
        new AutoDrumSpeed(m_Drum, Constants.AUTO_PERCENT_POWER_DRUM, Constants.AUTO_DRUM_WAIT_TIME)),
      new DriveDistance(m_Drive, Constants.AUTO_PERCENT_POWER_DRIVE, Constants.AUTO_DRIVE_DISTANCE_TO_TRAVEL_INCHES)
    );
  }
}
