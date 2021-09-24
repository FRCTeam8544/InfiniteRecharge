// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DemoModes;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class SlowDemoMode extends CommandBase {
  /** Creates a new SlowDemoMode. */
  DriveTrain m_drivetrain;
  double leftSpeed, rightSpeed;

  public SlowDemoMode(DriveTrain drive) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drivetrain = drive; 
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.printDemoSwitch();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    leftSpeed =  -RobotContainer.leftDriveController.getRawAxis(1);
    rightSpeed = -RobotContainer.rightDriveController.getRawAxis(1);
    m_drivetrain.tankDrive(m_drivetrain.rampRate(leftSpeed, .3, .2, .5), m_drivetrain.rampRate(rightSpeed, .3, .2, .5));
    SmartDashboard.putNumber("Left Speed: ", leftSpeed);
    SmartDashboard.putNumber("Right Speed: ", rightSpeed);
    SmartDashboard.putString("Slow Mode: ", "scheduled");
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
