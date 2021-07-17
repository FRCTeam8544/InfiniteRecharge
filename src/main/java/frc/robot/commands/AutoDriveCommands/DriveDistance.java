// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoDriveCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class DriveDistance extends CommandBase {
  /** Creates a new DriveDistance. */
  DriveTrain m_drivetrain; 
  double m_speed, m_distance;
  double kP;

  public DriveDistance(DriveTrain drive, double speed, double distance) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drivetrain = drive;
    m_speed = speed;
    m_distance = distance;
    kP = 0.12;
    
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
    //currentRM = # of rotations of the motor 
    m_drivetrain.currentRM(m_drivetrain.frontLeftEncoder);
    m_drivetrain.tankDrive(-m_speed /*- kP * m_drivetrain.error()*/, -m_speed /*+ kP * m_drivetrain.error()*/);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //testing to see whether encoder value is negative or positive 
    //see drivetrain for revperinch calculation explanation
    if (m_drivetrain.currentRM(m_drivetrain.frontLeftEncoder) > 0){
      return (m_drivetrain.currentRM(m_drivetrain.frontLeftEncoder) > m_drivetrain.revPerInchCalc(m_distance));
    }
    //negative encoder value --> changed sign to less than 
    else if (m_drivetrain.currentRM(m_drivetrain.frontLeftEncoder) != 0) {
      return ((-1) * m_drivetrain.currentRM(m_drivetrain.frontLeftEncoder) > m_drivetrain.revPerInchCalc(m_distance));
    }
    else {
      return false;
    }
  }
}
