// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants;

public class NavXTurnAngle extends CommandBase {
  // Represents the navX yaw reading the robot should finish at
  double targetYaw;
  // Represents the intended change in yaw
  double deltaYaw;
  DriveTrain m_drivetrain;
  AHRS ahrs;
  double currentYaw;
  public static int navXexecutionCount = 0;

  // Assigning to the field the paramenter using "this." syntax
  public NavXTurnAngle(DriveTrain m_drivetrain, double deltaYaw) {
    this.m_drivetrain = m_drivetrain;
    this.deltaYaw = deltaYaw;
    ahrs = new AHRS(SPI.Port.kMXP);
    addRequirements(m_drivetrain);
  }

  @Override
  public void initialize() {
    targetYaw = ahrs.getAngle() + deltaYaw;
  }

  @Override
  public void execute() {
    if (deltaYaw > 0) {
      m_drivetrain.tankDrive(-Constants.DRIVETRAIN_NAVX_TURN_TEST_POWER, Constants.DRIVETRAIN_NAVX_TURN_TEST_POWER); 
    }
    else {
      m_drivetrain.tankDrive(Constants.DRIVETRAIN_NAVX_TURN_TEST_POWER, -Constants.DRIVETRAIN_NAVX_TURN_TEST_POWER);
    }
    SmartDashboard.putNumber("deltaYaw: ", deltaYaw);
    SmartDashboard.putNumber("navXexecutionCount: ", navXexecutionCount++);
  }

  @Override
  public void end(boolean interrupted) {
    m_drivetrain.tankDrive(0,0);
  }


  @Override
  public boolean isFinished() {
    currentYaw = ahrs.getAngle();

    if (deltaYaw > 0 ? currentYaw >= targetYaw : currentYaw <= targetYaw) {
      SmartDashboard.putNumber("currentYaw at finished: ", currentYaw);
      SmartDashboard.putNumber("targetYaw at finished: ", targetYaw);
      return true;
    }
    SmartDashboard.putNumber("currentYaw: ", currentYaw);
    SmartDashboard.putNumber("targetYaw: ", targetYaw);
    return false; 
  }
}