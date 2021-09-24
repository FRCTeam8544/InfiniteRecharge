// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DemoModes;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class TurnOnlyDemoMode extends CommandBase {
  /** Creates a new TurnOnlyDemoMode. */
  DriveTrain m_drivetrain;
  double leftSpeed, rightSpeed;

  public TurnOnlyDemoMode(DriveTrain drive) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drivetrain = drive;
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    leftSpeed =  -RobotContainer.leftDriveController.getRawAxis(0);
    m_drivetrain.turnOnlyDrive(leftSpeed);
    SmartDashboard.putString("Turn Only Drive: ", "scheduled");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
