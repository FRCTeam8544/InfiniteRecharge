// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Turn90 extends CommandBase {
  /** Creates a new Turn90. */
  public Turn90() {
    // Use addRequirements() here to declare subsystem dependencies.
  }
  final double wheelBase = 22;
  final double wheelDiameter = 6; // Inches
  final double gearRatio = 10.71; // gearing down
  final double inchesPerRevWheel = wheelDiameter * Math.PI;
  //double pulsePerInch = pulsePerRevMotor * (gearRatio / inchesPerRevWheel);
  final double revMotorPerInch = gearRatio / inchesPerRevWheel; 
  double currentRM; 

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_driveTrain.driveEncoder1.setPosition(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    currentRM = RobotContainer.m_driveTrain.driveEncoder1.getPosition();
    RobotContainer.m_driveTrain.robotDrive.tankDrive(.5, .5);
    SmartDashboard.putNumber("Current RM: ", currentRM);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
     // proportional gain = ratio of input to output 
     double kP = 1;
     // error is the setpoint minus process variable 
     double error = 90 - RobotContainer.m_navx.m_gyro.getAngle();
     RobotContainer.m_driveTrain.robotDrive.tankDrive(kP * error, kP * error);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;//(currentRM > 60 * revMotorPerInch);
  }
}
