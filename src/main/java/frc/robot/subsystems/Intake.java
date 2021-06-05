// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  DigitalInput topLimitSwitch = null;
  DigitalInput bottomLimitSwitch = null;
  VictorSPX intakeMotor = null;

  public Intake() {
    intakeMotor = new VictorSPX(2);

    topLimitSwitch = new DigitalInput(1);
    bottomLimitSwitch = new DigitalInput(2);

  }
  public void setIntakeMotorSpeed (double intakeMotorSpeed) {
    intakeMotor.set(ControlMode.PercentOutput, intakeMotorSpeed);

  }
  
  public void setIntakePosition(double speed) {
    speed = intakeMotor.getMotorOutputPercent();
    //check to make sure this is actually doing what you want 
    if (speed > 0) {
      if (topLimitSwitch.get() == true) {
        intakeMotor.set(ControlMode.PercentOutput, 0);
      }
      else  {
        intakeMotor.set(ControlMode.PercentOutput, -0.5);
      }
    }
    else {
      if (bottomLimitSwitch.get() == true) {
        intakeMotor.set(ControlMode.PercentOutput, 0);
      }
      else {
        intakeMotor.set(ControlMode.PercentOutput, 0.5);
      }
    }
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
