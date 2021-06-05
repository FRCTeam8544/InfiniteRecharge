// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FeederDrum extends SubsystemBase {
  /** Creates a new FeederDrum. */
  public VictorSPX drumMotor = null;
  public FeederDrum() {
  drumMotor = new VictorSPX(3);
  
  
  
  //SmartDashboard.putNumber("Drum Speed", drumMotor.getMotorOutputPercent());
  }
/*public void setSpeedDrumMotor(){
double drumSpeed = drumMotor.getMotorOutputPercent();

 if (drumSpeed == 0){
drumMotor.set(Constants.FEEDERDRUM_DRUM_MOTOR_CONTROL_OUTPUT, Constants.FEEDERDRUM_DRUM_MOTOR_SPEED);
 }
 else {
   drumMotor.set(Constants.FEEDERDRUM_DRUM_MOTOR_CONTROL_OUTPUT, 0);
 }
}*/

public void setDrumMotorSpeedJoytick(double drumWheelSpeed) {
  drumMotor.set(ControlMode.PercentOutput, drumWheelSpeed);
}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
