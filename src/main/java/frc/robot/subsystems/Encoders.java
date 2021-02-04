// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.Constants;

public class Encoders extends SubsystemBase {
  /** Creates a new Encoders. */
  CANEncoder sparkMaxDriveEncoder1 = null;
  CANEncoder sparkMaxDriveEncoder2 = null;
  CANEncoder sparkMaxDriveEncoder3 = null;
  CANEncoder sparkMaxDriveEncoder4 = null;

  CANEncoder sparkMaxShooterEncoder1 = null;
  CANEncoder sparkMaxShooterEncoder2 = null;

  public Encoders() {
  sparkMaxDriveEncoder1 = new CANEncoder(RobotContainer.m_drivetrain.driveMotor1, Constants.ENCODERS_DRIVE_ENCODER_1_SENSOR_TYPE, Constants.ENCODERS_DRIVE_ENCODER_1_CPR);
  sparkMaxDriveEncoder2 = new CANEncoder(RobotContainer.m_drivetrain.driveMotor2, Constants.ENCODERS_DRIVE_ENCODER_2_SENSOR_TYPE, Constants.ENCODERS_DRIVE_ENCODER_2_CPR);
  sparkMaxDriveEncoder3 = new CANEncoder(RobotContainer.m_drivetrain.driveMotor3, Constants.ENCODERS_DRIVE_ENCODER_3_SENSOR_TYPE, Constants.ENCODERS_DRIVE_ENCODER_3_CPR);
  sparkMaxDriveEncoder4 = new CANEncoder(RobotContainer.m_drivetrain.driveMotor4, Constants.ENCODERS_DRIVE_ENCODER_4_SENSOR_TYPE, Constants.ENCODERS_DRIVE_ENCODER_4_CPR);
  
  sparkMaxShooterEncoder1 = new CANEncoder(RobotContainer.m_Shooter.topWheelSparkMax, Constants.ENCODERS_SHOOTER_ENCODER_1_SENSOR_TYPE, Constants.ENCODERS_SHOOTER_ENCODER_1_CPR);
  sparkMaxShooterEncoder2 = new CANEncoder(RobotContainer.m_Shooter.bottomWheelSparkMax, Constants.ENCODERS_SHOOTER_ENCODER_2_SENSOR_TYPE, Constants.ENCODERS_SHOOTER_ENCODER_2_CPR);
}

  public void getCPRDriveMotors(){
    SmartDashboard.putNumber("Drive Motor 1 Encoder Counts", sparkMaxDriveEncoder1.getCountsPerRevolution());
    SmartDashboard.putNumber("Drive Motor 2 Encoder Counts", sparkMaxDriveEncoder2.getCountsPerRevolution());
    }

  public void getCPRShooterWheel(){
    SmartDashboard.putNumber("Top Shooter Wheel Encoder Counts", sparkMaxShooterEncoder1.getCountsPerRevolution());
    SmartDashboard.putNumber("Bottom Shooter Wheel Encoder Counts", sparkMaxShooterEncoder2.getCountsPerRevolution());
  }

    
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
