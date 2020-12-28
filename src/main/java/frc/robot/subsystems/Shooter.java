/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;





public class Shooter extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */
  CANSparkMax topWheelSparkMax = null;
  CANSparkMax bottomWheelSparkMax = null;
  DoubleSolenoid shooterPiston = null;

  //this is for buttons 
  


  
  public Shooter() {
    //constructor for shooter 
    //second parameter is motor type (either brushed or brushless)
    topWheelSparkMax = new CANSparkMax(Constants.SHOOTER_TOP_WHEEL_SPARK_MAX, Constants.MOTOR_TYPE_SHOOTER_TOP_WHEEL_SPARK_MAX);    
    bottomWheelSparkMax = new CANSparkMax(Constants.SHOOTER_BOTTOM_WHEEL_SPARK_MAX, Constants.MOTOR_TYPE_SHOOTER_BOTTOM_WHEEL_SPARK_MAX);

    //piston for controlling ball entry into shooter wheels
    shooterPiston = new DoubleSolenoid(Constants.SHOOTER_PISTON_POSITION, Constants.SHOOTER_SHOOT_PISTON_FORWARD, Constants.SHOOTER_SHOOT_PISTON_REVERSE);
  }

  public void setShooterSpeedCombo(int shooterSpeedCombo){
    //this statements program the buttons for the shooter speeds
    if (shooterSpeedCombo == 1){
      topWheelSparkMax.set(Constants.SHOOTER_TOP_WHEEL_SPEED_1);
      bottomWheelSparkMax.set(Constants.SHOOTER_BOTTOM_WHEEL_SPEED_1);
    }
    else if (shooterSpeedCombo == 2){
      topWheelSparkMax.set(Constants.SHOOTER_TOP_WHEEL_SPEED_2);
      bottomWheelSparkMax.set(Constants.SHOOTER_BOTTOM_WHEEL_SPEED_2);
    }
    else if (shooterSpeedCombo == 3){
      topWheelSparkMax.set(Constants.SHOOTER_TOP_WHEEL_SPEED_3);
      bottomWheelSparkMax.set(Constants.SHOOTER_BOTTOM_WHEEL_SPEED_3);
    }
    else if (shooterSpeedCombo == 4){
      topWheelSparkMax.set(Constants.SHOOTER_TOP_WHEEL_SPEED_4);
      bottomWheelSparkMax.set(Constants.SHOOTER_BOTTOM_WHEEL_SPEED_4);
    }
    else {
      new PrintCommand("Shooter.setShooterSpeedCombo Unknown Speed Specified");
    }
  }
  //~try to figure out how to make int type --> string type w/o breaking the code 
  public void setpistonPositionRapidShoot(boolean pistonPositionRapidShoot) {
    if (pistonPositionRapidShoot == true){
    shooterPiston.set(Constants.SHOOTER_PISTON_POSITION_REVERSE);
    }
    else {
    shooterPiston.set(Constants.SHOOTER_PISTON_POSITION_FORWARD);
    }
  }
  
  public void setPistonPositionSingleShot(Boolean pistonPositionSingleShot){

  
    if (pistonPositionSingleShot == true){
      shooterPiston.set(Constants.SHOOTER_PISTON_POSITION_REVERSE);
      new WaitUntilCommand(5);
      shooterPiston.set(Constants.SHOOTER_PISTON_POSITION_FORWARD);
    }
    else {
      shooterPiston.set(Constants.SHOOTER_PISTON_POSITION_FORWARD);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
