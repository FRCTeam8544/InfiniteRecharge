// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.tankDrive;
import net.thefletcher.revrobotics.CANEncoder;
import net.thefletcher.revrobotics.CANPIDController;
import net.thefletcher.revrobotics.CANSparkMax;
import net.thefletcher.revrobotics.enums.ControlType;
import net.thefletcher.revrobotics.enums.EncoderType;
import net.thefletcher.revrobotics.enums.MotorType;
public class DriveTrain extends SubsystemBase {
 
  /** Creates a new DriveTrain. */
  public CANSparkMax driveMotor1 = null;
  public CANSparkMax driveMotor2 = null;
  CANSparkMax driveMotor3 = null;
  CANSparkMax driveMotor4 = null;

  public CANEncoder driveEncoder1 = null;
  public CANEncoder driveEncoder2 = null;
  CANEncoder driveEncoder3 = null;
  CANEncoder driveEncoder4 = null;

  CANPIDController drivePIDController1 = null;
  CANPIDController drivePIDController2 = null;

  public DifferentialDrive robotDrive = null;
  
  public Joystick leftController = null;
  public Joystick rightController = null;
  //public Joystick HIDController = null;

  public Timer driveTimer = null;

  public static double encoderValueSim1 = 0;
  static double encoderValueSim2 = 0;
  
  

  public DriveTrain() {
    
    driveMotor1 = new CANSparkMax(Constants.DRIVETRAIN_DRIVE_MOTOR_1, Constants.DRIVETRAIN_DRIVE_MOTOR_1_TYPE);
    driveMotor3 = new CANSparkMax(Constants.DRIVETRAIN_DRIVE_MOTOR_3, Constants.DRIVETRAIN_DRIVE_MOTOR_3_TYPE);

    driveMotor1.restoreFactoryDefaults();
    driveMotor3.restoreFactoryDefaults();

    SpeedControllerGroup leftMotors = new SpeedControllerGroup(driveMotor1, driveMotor3);
    
    driveMotor2 = new CANSparkMax(Constants.DRIVETRAIN_DRIVE_MOTOR_2,Constants.DRIVETRAIN_DRIVE_MOTOR_2_TYPE);
    driveMotor4 = new CANSparkMax(Constants.DRIVETRAIN_DRIVE_MOTOR_4, Constants.DRIVETRAIN_DRIVE_MOTOR_4_TYPE);

    driveMotor2.restoreFactoryDefaults();
    driveMotor4.restoreFactoryDefaults();

    SpeedControllerGroup rightMotors = new SpeedControllerGroup(driveMotor2, driveMotor4);

    /*driveEncoder1 = new CANEncoder(driveMotor1, EncoderType.kHallSensor, 42);
    driveEncoder2 = new CANEncoder(driveMotor2, EncoderType.kQuadrature, 42);
    driveEncoder3 = new CANEncoder(driveMotor3, EncoderType.kQuadrature, 42);
    driveEncoder4 = new CANEncoder(driveMotor4, EncoderType.kQuadrature, 42);*/
    try {
    driveEncoder1 = driveMotor1.getEncoder(EncoderType.kHallSensor, 42);
    driveEncoder2 = driveMotor2.getEncoder(EncoderType.kHallSensor, 42);
    driveEncoder3 = driveMotor3.getEncoder(EncoderType.kHallSensor, 42);
    driveEncoder4 = driveMotor4.getEncoder(EncoderType.kHallSensor, 42);
    }
    catch (RuntimeException ex) {
      DriverStation.reportError("CANEncoder Error: " + ex.getMessage(), true);
    }
    
    //driveMotor1.setIdleMode(IdleMode.kCoast);
    //driveMotor2.setIdleMode(IdleMode.kCoast);
    //driveMotor3.setIdleMode(IdleMode.kCoast);
    //driveMotor4.setIdleMode(IdleMode.kCoast);

    driveMotor1.setInverted(Constants.DRIVETRAIN_DRIVE_MOTOR_1_INVERSION);
    driveMotor3.follow(driveMotor1);

    driveMotor2.setInverted(Constants.DRIVETRAIN_DRIVE_MOTOR_2_INVERSION);
    driveMotor4.follow(driveMotor2);



    robotDrive = new DifferentialDrive(leftMotors, rightMotors);

    leftController = new Joystick(Constants.DRIVETRAIN_LEFT_JOYSTICK_CONTROLLER);
    rightController = new Joystick(Constants.DRIVETRAIN_RIGHT_JOYSTICK_CONTROLLER);

    drivePIDController1 = driveMotor1.getPIDController();
    drivePIDController2 = driveMotor2.getPIDController();

    driveTimer = new Timer();
    
    

    //HIDController = new Joystick(Constants.DRIVETRAIN_HID_CONTROLLLER);

    //CommandScheduler.registerSubsystem(RobotContainer.m_driveTrain);

      //setDefaultCommand(new tankDrive());
      //SmartDashboard.putString("Default Command Drive Train: ", getDefaultCommand());
    }
  
//makes tank drive the default command for this subsystem --> I am hoping this will work for the error of Output not updated enough
    /*public void getIdleModeSetting(CANSparkMax motorIdleMode){
      if (motorIdleMode.getIdleMode() == IdleMode.kCoast){
        SmartDashboard.putString("Idle Mode: ","Coast");
      }
    else{
      SmartDashboard.putString("Idle Mode: ","Brake");
    }
  }*/

  public double clip(double powerValue) {
    return (powerValue > Constants.CLIPVALUE ? Constants.CLIPVALUE : (powerValue < -Constants.CLIPVALUE ? -Constants.CLIPVALUE : powerValue));
  }
  

  public void tankDrive(double leftSpeed, double rightSpeed){
    robotDrive.tankDrive(leftSpeed, rightSpeed);
  }

  public void resetEncoders() {
    driveEncoder1.setPosition(0);
    driveEncoder2.setPosition(0);
  }

  public double errorCalc() {
    
      return (driveEncoder1.getPosition() - driveEncoder2.getPosition());
  }
public double errorCalcSim() {
    encoderValueSim1 += .1;
    encoderValueSim2 += .2;
    encoderValueSim2 -= .1;
     return (encoderValueSim1 - encoderValueSim2);}

  

  public final double revMotorPerInchCalc() {
    final double wheelBase = 22;
  final double wheelDiameter = 6; // Inches
  final double gearRatio = 10.71; // gearing down
  final double inchesPerRevWheel = wheelDiameter * Math.PI;
  //double pulsePerInch = pulsePerRevMotor * (gearRatio / inchesPerRevWheel);
  final double revMotorPerInch = gearRatio / inchesPerRevWheel; 
  return (revMotorPerInch);
  }
 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
