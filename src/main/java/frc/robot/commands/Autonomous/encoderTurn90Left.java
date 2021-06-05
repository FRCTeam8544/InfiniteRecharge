// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class encoderTurn90Left extends CommandBase {
  /** Creates a new encoderTurn90Left. */
  Timer m_timer;
  public encoderTurn90Left() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_driveTrain.driveEncoder1.setPosition(0);
 
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.m_driveTrain.tankDrive(.7, -.7);
    SmartDashboard.putNumber("Encoder 1 Value", RobotContainer.m_driveTrain.driveEncoder1.getPosition());
    SmartDashboard.putNumber("Encoder 2 Value", RobotContainer.m_driveTrain.driveEncoder2.getPosition());
    SmartDashboard.putNumber("Speed is :", RobotContainer.m_driveTrain.driveMotor1.getOutputCurrent());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_driveTrain.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //(RobotContainer.m_driveTrain.driveEncoder1.getPosition() > 9.4)
    return  false;
  }
}