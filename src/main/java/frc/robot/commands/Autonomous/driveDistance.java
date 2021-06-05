// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class driveDistance extends CommandBase {
  /** Creates a new driveDistance. */
  double m_speedToTravel;
  double m_inchesToTravel;
  double currentRM;
  public driveDistance(double speed, double distanceInches) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_driveTrain);
    m_speedToTravel = speed;
    m_inchesToTravel = distanceInches;
  
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_driveTrain.tankDrive(0, 0);
    RobotContainer.m_driveTrain.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    currentRM =  RobotContainer.m_driveTrain.driveEncoder1.getPosition();
    double kP = .12;
    RobotContainer.m_driveTrain.tankDrive(m_speedToTravel + kP * RobotContainer.m_driveTrain.errorCalcSim(), m_speedToTravel - kP * RobotContainer.m_driveTrain.errorCalcSim());
    SmartDashboard.putNumber("Motor 1: ",  RobotContainer.m_driveTrain.driveMotor1.get());
    SmartDashboard.putNumber("Motor 2: ",  RobotContainer.m_driveTrain.driveMotor2.get());

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_driveTrain.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (currentRM < 0) {
      return (currentRM < -(m_inchesToTravel *  RobotContainer.m_driveTrain.revMotorPerInchCalc()));
    }
    else {
      return (currentRM > m_inchesToTravel *  RobotContainer.m_driveTrain.revMotorPerInchCalc());
    }
  }
}
