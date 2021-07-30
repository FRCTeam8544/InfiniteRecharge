// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeArm extends SubsystemBase {
  /** Creates a new IntakeArm. */
  WPI_VictorSPX armMotor;

  DigitalInput topArmLimitSwitch;
  DigitalInput bottomArmLimitSwitch;

  public IntakeArm() {
  //armMotor = new WPI_VictorSPX(Constants.INTAKEARM_ARM_MOTOR_ID);

  armMotor.setInverted(true);

  //topArmLimitSwitch = new DigitalInput(Constants.INTAKEARM_TOP_ARM_LIMIT_SWITCH_CHANNEL);
  //bottomArmLimitSwitch = new DigitalInput(Constants.INTAKEARM_BOTTOM_ARM_LIMIT_SWITCH_CHANNEL);
  }

  public void setMotorSpeed (double speed){
    armMotor.set(speed);
  }

  //testing to see whether or not limit switches have been triggered --> if they are motors stop; otherwise motors continue at set speed with button
  public void setArmMotorSpeed(double speed){
    if (speed > 0){
      if (topArmLimitSwitch.get()){
        stopArmMotor();
      }
      else {
        armMotor.set(speed);
      }
    }

    else {
      if (bottomArmLimitSwitch.get()){
        stopArmMotor();
      }
      else {
        armMotor.set(speed);
      }
    }
  }
  

  public void stopArmMotor(){
    armMotor.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
