// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class driveForward extends CommandBase {
  /** Creates a new driveForward. */
  double m_distanceToTravel;
  public driveForward(double distanceInches) {
    addRequirements(RobotContainer.m_driveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
    m_distanceToTravel = distanceInches;
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
   RobotContainer.m_driveTrain.robotDrive.tankDrive(-.3, -.3);
   SmartDashboard.putNumber("Current ForwardDrive RM: ", currentRM);
   SmartDashboard.putString("DriveForward was: ", "Called");
   SmartDashboard.putNumber("Motor 1: ", RobotContainer.m_driveTrain.driveMotor1.get());
    SmartDashboard.putNumber("Motor 2: ", RobotContainer.m_driveTrain.driveMotor2.get());
   //DriverStation.reportError("Current RM" + currentRM, true);
 }

 // Called once the command ends or is interrupted.
 @Override
 public void end(boolean interrupted) {
   RobotContainer.m_driveTrain.robotDrive.tankDrive(0, 0);
   //SmartDashboard.putString("Drive Forward was: ", "Ended");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (currentRM < m_distanceToTravel * revMotorPerInch);
  }
}
