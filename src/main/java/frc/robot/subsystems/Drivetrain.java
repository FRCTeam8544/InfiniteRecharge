/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;


public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new Drivetrain.
   */
   public CANSparkMax driveMotor1 = null;
   public CANSparkMax driveMotor2 = null;
   public CANSparkMax driveMotor3 = null;
   public CANSparkMax driveMotor4 = null;

   
  

  public Drivetrain() {
  driveMotor1 = new CANSparkMax(Constants.DRIVETRAIN_DRIVE_MOTOR_1, Constants.DRIVETRAIN_DRIVE_MOTOR_1_MOTOR_TYPE);
  driveMotor2 = new CANSparkMax(Constants.DRIVETRAIN_DRIVE_MOTOR_2, Constants.DRIVETRAIN_DRIVE_MOTOR_2_MOTOR_TYPE);
  driveMotor3 = new CANSparkMax(Constants.DRIVETRAIN_DRIVE_MOTOR_3, Constants.DRIVETRAIN_DRIVE_MOTOR_3_MOTOR_TYPE);
  driveMotor4 = new CANSparkMax(Constants.DRIVETRAIN_DRIVE_MOTOR_4, Constants.DRIVETRAIN_DRIVE_MOTOR_4_MOTOR_TYPE);

  driveMotor1.setInverted(Constants.DRIVETRAIN_DRIVE_MOTOR_1_INVERSION);
  driveMotor2.setInverted(Constants.DRIVETRAIN_DRIVE_MOTOR_2_INVERSION);

  SpeedControllerGroup rightMotors = new SpeedControllerGroup(driveMotor1, driveMotor3);
  SpeedControllerGroup leftMotors = new SpeedControllerGroup(driveMotor4, driveMotor2);
  
  DifferentialDrive drive = new DifferentialDrive(leftMotors, rightMotors);
  
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
