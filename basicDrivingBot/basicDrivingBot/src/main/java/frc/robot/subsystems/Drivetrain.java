/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
    Talon motorNameLeftFront = null;
    Talon motorNameRightFront = null;
    Talon motorNameLeftBack = null;
    Talon motorNameRightBack = null;
    SpeedControllerGroup leftMotors = null;
    SpeedControllerGroup rightMotors = null;

    DifferentialDrive differentialdrive = null;
    /**
   * Creates a new Drivetrain.
   */
  public Drivetrain() {
    // This is the constructor for the talon class
      motorNameLeftFront = new Talon(Constants.DRIVETRAIN_MOTOR_NAME_LEFT_FRONT);
      motorNameRightFront = new Talon(Constants.DRIVETRAIN_MOTOR_NAME_RIGHT_FRONT);
      motorNameLeftBack = new Talon(Constants.DRIVETRAIN_MOTOR_NAME_LEFT_BACK);
      motorNameRightBack = new Talon(Constants.DRIVETRAIN_MOTOR_NAME_LEFT_BACK);
      leftMotors = new SpeedControllerGroup(motorNameLeftFront, motorNameLeftBack);
      rightMotors = new SpeedControllerGroup(motorNameRightBack, motorNameRightFront);
      differentialdrive = new DifferentialDrive(leftMotors, rightMotors);

  }
  public void arcadeDrive (double moveSpeed, double rotateSpeed) {
    differentialdrive.arcadeDrive(moveSpeed, rotateSpeed);

  

}
  @Override
  public void periodic() {
   
    // This method will be called once per scheduler run
  }
}
