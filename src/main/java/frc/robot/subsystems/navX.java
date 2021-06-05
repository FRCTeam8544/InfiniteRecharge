// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class navX extends SubsystemBase {
  /** Creates a new navX. */
  public AHRS m_gyro = null;
  Joystick HIDController = null;
  
  public navX() {
    
    
    try{
      m_gyro = new AHRS(Constants.NAVX_GYRO_PORT, Constants.NAVX_GYRO_UPDATE_RATE);
      m_gyro.enableLogging(Constants.NAVX_GYRO_ENABLE_LOGGING);
    }
  
    catch (RuntimeException ex){
      DriverStation.reportError("Error Instantiation navX MXP: " + ex.getMessage(), true);
    }
  }
  
    public void getYaw(){
      boolean zeroYawPressed = HIDController.getTrigger();
      if (zeroYawPressed){
        m_gyro.zeroYaw();
      }
    }
  
    public void SmartDashboardDisplaysNavX(){
      SmartDashboard.putBoolean("IMU_Connected", m_gyro.isConnected());
      SmartDashboard.putBoolean("IMU_IsCalibrating", m_gyro.isCalibrating());
      SmartDashboard.getNumber("IMU_Yaw", m_gyro.getYaw());
    }
  
    public void ShuffleBoardCompass(){
      Shuffleboard.getTab("Compass").add((Sendable) m_gyro);
    }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
