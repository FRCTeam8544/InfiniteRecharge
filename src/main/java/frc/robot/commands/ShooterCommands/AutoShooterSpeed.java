// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ShooterCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class AutoShooterSpeed extends CommandBase {
  /** Creates a new AutoShooterSpeed. */
  Shooter m_shooter;
  double percentPower;
  double lengthOfCommand;
  Timer shooterTimer;

  public AutoShooterSpeed(Shooter shooter, double speed, double seconds) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_shooter = shooter;
    percentPower = speed;
    lengthOfCommand = seconds;

    addRequirements(m_shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    ////reseting timer
    shooterTimer.reset();
    //starting timer which will measure the amount of time in seconds before the command will begin 
    shooterTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooter.setPercentPower(percentPower);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shooter.stopShooter();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //command will finish when the value of the timer (in seconds) greater than or equal to the preset (set in parameter of command) length of the command in seconds
    return (shooterTimer.get() >= lengthOfCommand);
  }
}
