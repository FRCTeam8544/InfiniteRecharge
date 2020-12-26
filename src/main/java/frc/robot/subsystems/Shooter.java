/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;


public class Shooter extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */
  CANSparkMax topWheelSparkMax = null;
  CANSparkMax bottomWheelSparkMax = null;
  

  //this is for buttons 
  DigitalInput shooterSwitchSpeed1 = null;
  DigitalInput shooterSwitchSpeed2 = null;
  DigitalInput shooterSwitchSpeed3 = null;
  DigitalInput shooterSwitchSpeed4 = null;
  DigitalInput shooterSwitchShoot = null;


  //encoder
  Encoder shooterEncoder = null;
  
  public Shooter() {
    //constructor for shooter 
    //second parameter is motor type (either brushed or brushless)
    topWheelSparkMax = new CANSparkMax(Constants.SHOOTER_TOP_WHEEL_SPARK_MAX, Constants.MOTOR_TYPE_SHOOTER_TOP_WHEEL_SPARK_MAX);    
    bottomWheelSparkMax = new CANSparkMax(Constants.SHOOTER_BOTTOM_WHEEL_SPARK_MAX, Constants.MOTOR_TYPE_SHOOTER_BOTTOM_WHEEL_SPARK_MAX);

    //this is for buttons 
    shooterSwitchSpeed1 = new DigitalInput(Constants.SHOOTER_SHOOTER_SWITCH_SPEED_1);

    //encoder
    shooterEncoder = new Encoder(Constants.SHOOTER_ENCODER_A, Constants.SHOOTER_ENCODER_B);

    
  }
    //speed 1
  public boolean isShooterSwitchClosed(){
    //tells us when the shooter switch is pressed
    return shooterSwitchSpeed1.get();
  }

  public double getShooterEncoderCount(){
    return shooterEncoder.get();
  }

  public void resetShooterEncoderCount(){
    shooterEncoder.reset();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
