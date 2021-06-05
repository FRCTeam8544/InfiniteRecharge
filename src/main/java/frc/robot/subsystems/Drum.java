// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drum extends SubsystemBase {
  /** Creates a new Drum. */
  public WPI_VictorSPX drumMotor;

  public Drum() {
    drumMotor = new WPI_VictorSPX(Constants.DRUM_DRUM_MOTOR_ID);
    
  }

  //sets the speed of the drum with a joystick --> see the drum speed command for the joystick axis
  public void setDrumSpeed(double speed){
    drumMotor.set(speed);
  }

  public void drumMotorOff(){
    drumMotor.set(0);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
