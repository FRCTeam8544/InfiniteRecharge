// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class Climber extends SubsystemBase {
  WPI_VictorSPX winchMotor;

  public Climber() {
    winchMotor = new WPI_VictorSPX(Constants.CLIMBER_WINCH_ARM_MOTOR_ID);
    // To Do: verify whether motor should be inverted during testing
    winchMotor.setInverted(true);
  }

  public double rampRate(double joystickPosition){
    // To Do: check whether .25 and .75 are the appropriate sensitivity values
    double preClippedPower = (.25 * (joystickPosition) + .75 * (Math.pow(joystickPosition, 3)));
    return preClippedPower < Constants.CLIMBER_CLIP_VALUE ? preClippedPower : Constants. CLIMBER_CLIP_VALUE;
  }

  public void setMotorSpeed (double speed){
    winchMotor.set(speed);
  }

  public void stopMotor(){
    winchMotor.set(0);
  }

  @Override
  public void periodic() {}
}
