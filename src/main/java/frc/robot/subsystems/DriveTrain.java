// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  CANSparkMax frontLeftDriveMotor;
  CANSparkMax backLeftDriveMotor;
  CANSparkMax frontRightDriveMotor;
  CANSparkMax backRightDriveMotor;
  
  SpeedControllerGroup leftMotors;
  SpeedControllerGroup rightMotors;

  DifferentialDrive robotDrive;

  public CANEncoder frontLeftEncoder;
  public CANEncoder backLeftEncoder;
  public CANEncoder frontRightEncoder;
  public CANEncoder backRightEncoder;

  public DriveTrain() {
    frontLeftDriveMotor = new CANSparkMax(Constants.DRIVETRAIN_FRONT_LEFT_DRIVE_MOTOR_ID, Constants.DRIVETRAIN_FRONT_LEFT_DRIVE_MOTOR_MOTORTYPE);
    backLeftDriveMotor = new CANSparkMax(Constants.DRIVETRAIN_BACK_LEFT_DRIVE_MOTOR_ID, Constants.DRIVETRAIN_BACK_LEFT_DRIVE_MOTOR_MOTORTYPE);

    frontRightDriveMotor = new CANSparkMax(Constants.DRIVETRAIN_FRONT_RIGHt_DRIVE_MOTOR_ID, Constants.DRIVETRAIN_FRONT_RIGHT_DRIVE_MOTOR_MOTORTYPE);
    backRightDriveMotor = new CANSparkMax(Constants.DRIVETRAIN_BACK_RIGHT_DRIVE_MOTOR_ID, Constants.DRIVETRAIN_BACK_RIGHT_DRIVE_MOTOR_MOTORTYPE);


    frontLeftDriveMotor.restoreFactoryDefaults();
    backLeftDriveMotor.restoreFactoryDefaults();
    
    frontRightDriveMotor.restoreFactoryDefaults();
    backLeftDriveMotor.restoreFactoryDefaults();


    frontLeftDriveMotor.setInverted(Constants.DRIVETRAIN_FRONT_LEFT_DRIVE_MOTOR_INVERSION);
    backLeftDriveMotor.follow(frontLeftDriveMotor);

    frontRightDriveMotor.setInverted(Constants.DRIVETRAIN_FRONT_RIGHT_DRIVE_MOTOR_INVERSION);
    backLeftDriveMotor.follow(frontRightDriveMotor);


    leftMotors = new SpeedControllerGroup(frontLeftDriveMotor, backLeftDriveMotor);
    rightMotors = new SpeedControllerGroup(frontRightDriveMotor, backRightDriveMotor);


    robotDrive = new DifferentialDrive(leftMotors, rightMotors);


    frontLeftEncoder = frontLeftDriveMotor.getEncoder(Constants.DRIVETRAIN_FRONT_LEFT_ENCODER_ENCODERTYPE, Constants.DRIVETRAIN_FRONT_LEFT_ENCODER_CPR);
    backLeftEncoder = backLeftDriveMotor.getEncoder(Constants.DRIVETRAIN_BACK_LEFT_ENCODER_ENCODERTYPE, Constants.DRIVETRAIN_BACK_LEFT_ENCODER_CPR);

    frontRightEncoder = frontRightDriveMotor.getEncoder(Constants.DRIVETRAIN_FRONT_RIGHT_ENCODER_ENCODERTYPE, Constants.DRIVETRAIN_FRONT_RIGHT_ENCODER_CPR);
    backRightEncoder = backRightDriveMotor.getEncoder(Constants.DRIVETRAIN_BACK_RIGHT_ENCODER_ENCODERTYPE, Constants.DRIVETRAIN_BACK_RIGHT_ENCODER_CPR);

  }

  public void tankDrive(double leftSpeed, double rightSpeed){
   robotDrive.tankDrive(leftSpeed, rightSpeed);
  }

  public double rampRate(double speed){
    //ramp rate calculation
  double rawSpeed = speed;
   double clippedSpeed = rawSpeed < Constants.DRIVETRAIN_CLIP_VALUE ? rawSpeed : Constants.DRIVETRAIN_CLIP_VALUE;
    return (.4 * (clippedSpeed) + .6 * (Math.pow(clippedSpeed, 3)));
  }

  public void resetEncoders(){
    //method sets rotation count of each encoder to zero acting as a reset function 
    frontLeftEncoder.setPosition(0);
    backLeftEncoder.setPosition(0);

    frontRightEncoder.setPosition(0);
    backRightEncoder.setPosition(0);
  }

  public double revPerInchCalc (double inches){
    double distance = inches;
    double wheelDiameter = 6; //in
    double wheelCircumference = Math.PI * wheelDiameter; //in
    double gearRatio = 10.71 /*motorRev*/ / 1 /*wheelRev*/; //10.72:1 reduction ratio
    //revolution of motor * circumference = distance travelled --> so revolutions of motor = distance travelled / circumference
    double wheelRevPerInch = 1 / wheelCircumference; //1 in / circumference = revolutions of wheel

    return distance * wheelRevPerInch * gearRatio;
  }

  public double currentRM(CANEncoder encoder){
    //specify which encoder to get position of in order to be able to use this method mulitple times --> i.e. it is a generic method to get positions of encoders
    //get position returns rotations of encoders --> to get count per rev use getCPR
    return encoder.getPosition();
  }

  public double error(){
    return (frontLeftEncoder.getPosition() - frontRightEncoder.getPosition());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
