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
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class Drivetrain extends SubsystemBase {
  /**
   * Creates a new Drivetrain.
   */
  //this is where you define variables; set to null to make sure no values are assigned 

  //defined VictorSPX motors
  WPI_VictorSPX leftFrontVictorSPX = null;
  WPI_VictorSPX leftBackVictorSPX = null;
  WPI_VictorSPX rightFrontVictorSPX = null;
  WPI_VictorSPX rightBackVictorSPX = null;
  
  //This defines the left and right motor controllers; differentialDrive only takes 2 parameters, so you have to create speed controller groups to combine like motors together
  SpeedControllerGroup leftMotors = null;
  SpeedControllerGroup rightMotors = null;

  //DifferentialDrive is needed for tankDrive
  DifferentialDrive differentialDrive = null;

  public Drivetrain() {
    //This is called the constructer; the constructer is where you assign values to variables
    
    leftFrontVictorSPX = new WPI_VictorSPX(Constants.DRIVETRAIN_LEFT_FRONT_VICTORSPX);
    leftBackVictorSPX = new WPI_VictorSPX(Constants.DRIVETRAIN_LEFT_BACK_VICTORSPX);
    rightFrontVictorSPX = new WPI_VictorSPX(Constants.DRIVETRAIN_RIGHT_FRONT_VICTORSPX);
    rightBackVictorSPX = new WPI_VictorSPX(Constants.DRIVETRAIN_RIGHT_BACK_VICTORSPX);


    //This defines the speed controller groups which are just similar motors groups together 
    leftMotors = new SpeedControllerGroup(leftFrontVictorSPX, leftBackVictorSPX);
    rightMotors = new SpeedControllerGroup(rightFrontVictorSPX, rightBackVictorSPX);



    //This just tells differentialDrive the motor groups to use
    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);


  }
public void tankDrive(double leftSpeed, double rightSpeed){
  differentialDrive.tankDrive(leftSpeed, rightSpeed);
  //can add 0.5 in front of leftSpeed and rigthSpeed which makes max speed = half speed 
  //rightSpeed = speed of right motors; leftSpeed = speed of left motors


}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
