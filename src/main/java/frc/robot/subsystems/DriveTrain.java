// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import net.thefletcher.revrobotics.CANEncoder;
import net.thefletcher.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  public CANSparkMax frontLeftDriveMotor;
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

  public DigitalInput demoModeSlow;
  public DigitalInput demoModeTurnOnly;

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
    backRightDriveMotor.follow(frontRightDriveMotor);


    leftMotors = new SpeedControllerGroup(frontLeftDriveMotor, backLeftDriveMotor);
    rightMotors = new SpeedControllerGroup(frontRightDriveMotor, backRightDriveMotor);


    robotDrive = new DifferentialDrive(leftMotors, rightMotors);


    frontLeftEncoder = frontLeftDriveMotor.getEncoder(Constants.DRIVETRAIN_FRONT_LEFT_ENCODER_ENCODERTYPE, Constants.DRIVETRAIN_FRONT_LEFT_ENCODER_CPR);
    backLeftEncoder = backLeftDriveMotor.getEncoder(Constants.DRIVETRAIN_BACK_LEFT_ENCODER_ENCODERTYPE, Constants.DRIVETRAIN_BACK_LEFT_ENCODER_CPR);

    frontRightEncoder = frontRightDriveMotor.getEncoder(Constants.DRIVETRAIN_FRONT_RIGHT_ENCODER_ENCODERTYPE, Constants.DRIVETRAIN_FRONT_RIGHT_ENCODER_CPR);
    backRightEncoder = backRightDriveMotor.getEncoder(Constants.DRIVETRAIN_BACK_RIGHT_ENCODER_ENCODERTYPE, Constants.DRIVETRAIN_BACK_RIGHT_ENCODER_CPR);

    demoModeSlow = new DigitalInput(Constants.DRIVETRAIN_DEMO_MODE_SLOW_PORT);
    demoModeTurnOnly = new DigitalInput(Constants.DRIVETRAIN_DEMO_MODE_TURN_ONLY_PORT);
  }

  public void tankDrive(double leftSpeed, double rightSpeed){
   robotDrive.tankDrive(leftSpeed, rightSpeed);
  }

  public void turnOnlyDrive(double leftSpeed){
    double leftJoystickValue = leftSpeed;
    if (leftJoystickValue >= 0.2){
      robotDrive.tankDrive(0.3, -0.3);
    }
    else if (leftJoystickValue <= -0.2){
      robotDrive.tankDrive(-0.3, 0.3);
    }
  }

  public double rampRate(double speed, double rawSpeedMultiplierInteger, double rawSpeedMultiplierCube, double speedClipValue){
    //ramp rate calculation
  double rawSpeed = speed;
  double clippedSpeed;
  double rampedSpeed;
  double leftMultiplier = rawSpeedMultiplierInteger;
  double rightMultiplier = rawSpeedMultiplierCube;
  double clipValue = speedClipValue;

  rampedSpeed = (leftMultiplier * (rawSpeed) + rightMultiplier * (Math.pow(rawSpeed, 3)));

  if (rampedSpeed > clipValue) {
      clippedSpeed = clipValue;
    }
    else if (rampedSpeed < -clipValue) {
      clippedSpeed = -clipValue; 
    }
    else {
      clippedSpeed = rampedSpeed;
    };

 return clippedSpeed;
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

  public void printDemoSwitch() {
    SmartDashboard.putBoolean("Switch Reading: ", demoModeSlow.get());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
