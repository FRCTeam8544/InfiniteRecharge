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
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;



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



  XboxController shooterController = null;
  Button speed1Button = null;
  
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

    //
    shooterController = new XboxController(Constants.SHOOTER_SHOOTER_CONTROLLER);

    //
    
    
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

  public void set(int speed){
    if (speed == 1){
      topWheelSparkMax.set(Constants.SHOOTER_TOP_WHEEL_SPEED_1);
      bottomWheelSparkMax.set(Constants.SHOOTER_BOTTOM_WHEEL_SPEED_1);
    }
    else if (speed == 2){
      topWheelSparkMax.set(Constants.SHOOTER_TOP_WHEEL_SPEED_2);
      bottomWheelSparkMax.set(Constants.SHOOTER_BOTTOM_WHEEL_SPEED_2);
    }
    else if (speed == 3){
      topWheelSparkMax.set(Constants.SHOOTER_TOP_WHEEL_SPEED_3);
      bottomWheelSparkMax.set(Constants.SHOOTER_BOTTOM_WHEEL_SPEED_3);
    }
    else if (speed == 4){
      topWheelSparkMax.set(Constants.SHOOTER_TOP_WHEEL_SPEED_4);
      bottomWheelSparkMax.set(Constants.SHOOTER_BOTTOM_WHEEL_SPEED_4);
    }
    else {
      //need to figure out error handling
      //System.out.println ("Shooter.set Unknown Speed Specified");
    }
  }
    //topWheelSparkMax.set(Constants.SHOOTER_TOP_WHEEL_SPEED_1);
    //bottomWheelSparkMax.set(Constants.SHOOTER_BOTTOM_WHEEL_SPEED_1);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
