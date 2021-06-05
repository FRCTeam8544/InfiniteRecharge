// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoDriveCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class TurnAngle90 extends CommandBase {
  /** Creates a new TurnAngle90. */
  DriveTrain m_drivetrain;
  double m_rightSpeed, m_leftSpeed;
  double m_endRM;

  public TurnAngle90(DriveTrain drive, double leftSpeed, double rightSpeed, double endRM) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drivetrain = drive;
    m_leftSpeed = leftSpeed;
    m_rightSpeed = rightSpeed;
    m_endRM = endRM;

    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivetrain.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.currentRM(m_drivetrain.frontLeftEncoder);
    m_drivetrain.tankDrive(m_leftSpeed, m_rightSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //checking to see whether the endRM (rotations of motor) is greater than zero in order to give the correct ending behavior
    if (m_endRM > 0){
      return (m_drivetrain.currentRM(m_drivetrain.frontLeftEncoder) > m_endRM);
    }
    else {
      return (m_drivetrain.currentRM(m_drivetrain.frontLeftEncoder) < m_endRM);
    }
  }
}
