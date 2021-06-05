// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;


public class tankDrive extends CommandBase {
  /** Creates a new tankDrive. */
  public tankDrive() {
    addRequirements(RobotContainer.m_driveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /*double stick1 = RobotContainer.m_driveTrain.HIDController.getRawAxis(-1);
    double stick2 = RobotContainer.m_driveTrain.HIDController.getRawAxis(-3);
    RobotContainer.m_driveTrain.driveMotor1.set(stick1);
    RobotContainer.m_driveTrain.driveMotor2.set(stick2);*/
    //double leftSpeed = RobotContainer.m_driveTrain.leftController.set(RobotContainer.m_driveTrain.leftJoystickValue);

    

    //double leftSpeed = RobotContainer.m_driveTrain.leftController.getRawAxis(1);
    //double rightSpeed = RobotContainer.m_driveTrain.rightController.getRawAxis(1);

    //left joystick exponential acceleration
    double leftJoystickOutput = RobotContainer.m_driveTrain.leftController.getRawAxis(1);
    double leftJoystickValue = (.3 * leftJoystickOutput + .7 * (Math.pow(leftJoystickOutput, 3)));
    

    //right joystick exponential acceleration
    double rightJoystickOutput = RobotContainer.m_driveTrain.rightController.getRawAxis(1);
    double rightJoystickValue = (.3 * rightJoystickOutput + .7 * (Math.pow(rightJoystickOutput, 3)));
    
    
    RobotContainer.m_driveTrain.tankDrive(RobotContainer.m_driveTrain.clip(leftJoystickValue), RobotContainer.m_driveTrain.clip(rightJoystickValue));
    SmartDashboard.putString("TankDrive was Called: ", "tankDrive");
   // RobotContainer.m_driveTrain.getIdleModeSetting(RobotContainer.m_driveTrain.driveMotor1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_driveTrain.tankDrive(0, 0);
  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
