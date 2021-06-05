// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class timerTurn90Right extends CommandBase {
  /** Creates a new timerTurn90. */
  public timerTurn90Right() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_driveTrain.driveTimer.reset();
    RobotContainer.m_driveTrain.driveTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.m_driveTrain.robotDrive.tankDrive(.2, -.2);
    SmartDashboard.putNumber("Timer: ", RobotContainer.m_driveTrain.driveTimer.get());
    SmartDashboard.putString("RightTurn was: ", "Called");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_driveTrain.robotDrive.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //6.11, 1.60
    return (RobotContainer.m_driveTrain.driveTimer.get() > 5.65);
  }
}
