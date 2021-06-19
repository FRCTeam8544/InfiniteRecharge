// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import net.thefletcher.revrobotics.CANEncoder;
import net.thefletcher.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  CANSparkMax topShooterWheel;
  CANSparkMax bottomShooterWheel;

  CANEncoder topWheelEncoder;
  CANEncoder bottomWheelEncoder;

  public Shooter() {
    topShooterWheel = new CANSparkMax(Constants.SHOOTER_TOP_SHOOTER_WHEEL_ID, Constants.SHOOTER_TOP_SHOOTER_WHEEL_MOTORTYPE);
    bottomShooterWheel = new CANSparkMax(Constants.SHOOTER_BOTTOM_SHOOTER_WHEEL_ID, Constants.SHOOTER_BOTTOM_SHOOTER_WHEEL_MOTORTYPE);

    topShooterWheel.restoreFactoryDefaults();
    bottomShooterWheel.restoreFactoryDefaults();

    topShooterWheel.setInverted(Constants.SHOOTER_TOP_SHOOTER_WHEEL_INVERSION);
    bottomShooterWheel.setInverted(Constants.SHOOTER_BOTTOM_SHOOTER_WHEEL_INVERSION);

    topWheelEncoder = topShooterWheel.getEncoder();
    bottomWheelEncoder = bottomShooterWheel.getEncoder();
  }

  //method to set specific speeds
  //colors correspond to the color of the button (I may change this because it might be a stupid way of doing it)
  //each if statement corresponds to a different speed and button --> robotContainer for button mappings
  //@change shooter speeds to correct values
  public void setShooterSpeed(String shooterSpeed){
    if (shooterSpeed == "red"){
      topShooterWheel.set(.8);
      bottomShooterWheel.set(.8);
    }
    else if (shooterSpeed == "blue"){
      topShooterWheel.set(.6);
      bottomShooterWheel.set(.6);
    }
    else if (shooterSpeed == "green"){
      topShooterWheel.set(.8);
      bottomShooterWheel.set(.8);
    }
    else if (shooterSpeed == "yellow"){
      topShooterWheel.set(.8);
      bottomShooterWheel.set(.8);
    }
    else {
      SmartDashboard.putString("SetShooterSpeed: ", "Unknown button specified");
    }
  }

  //sets both shooter speed controllers to zero (i.e. stopping the motors)
  public void stopShooter(){
    topShooterWheel.set(0);
    bottomShooterWheel.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
