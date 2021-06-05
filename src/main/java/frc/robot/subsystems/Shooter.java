// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import net.thefletcher.revrobotics.CANSparkMax;
import net.thefletcher.revrobotics.enums.MotorType;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
public CANSparkMax topShooterMotor = null;
CANSparkMax bottomShooterMotor = null;
public SpeedControllerGroup topAndBottomShooterMotor = null;

  public Shooter() {
    topShooterMotor = new CANSparkMax(1, MotorType.kBrushless);
    bottomShooterMotor = new CANSparkMax(2, MotorType.kBrushless);
    topAndBottomShooterMotor = new SpeedControllerGroup(topShooterMotor, bottomShooterMotor);
    topShooterMotor.restoreFactoryDefaults();
    bottomShooterMotor.restoreFactoryDefaults();

    bottomShooterMotor.setInverted(false);
    topShooterMotor.setInverted(true);

    

  }

  public void setShooterJoystick(double wheelSpeed) {
    topAndBottomShooterMotor.set(wheelSpeed);
  }

  public void setShooterSpeed(int shooterSpeedCombo){
    if (shooterSpeedCombo == 1){
      topShooterMotor.set(-.35);
      bottomShooterMotor.set(-.35);
      SmartDashboard.putNumber("Shooter Speed Combo 1: ", topShooterMotor.get());
    }
    else if (shooterSpeedCombo == 2){
      topShooterMotor.set(-.40);
      bottomShooterMotor.set(-.40);
      SmartDashboard.putNumber("Shooter Speed Combo 2: ", topShooterMotor.get() + bottomShooterMotor.get());
    }
    else if (shooterSpeedCombo == 3){
      topShooterMotor.set(-.8);
      bottomShooterMotor.set(-.8);
      SmartDashboard.putNumber("Shooter Speed Combo 3: ", topShooterMotor.get() + bottomShooterMotor.get());
    }
    else if (shooterSpeedCombo == 4){
      topShooterMotor.set(-.45);
      bottomShooterMotor.set(-.45);
      SmartDashboard.putNumber("Shooter Speed Combo 4: ", topShooterMotor.get() + bottomShooterMotor.get());
    }
    else {
      SmartDashboard.putNumber("Shooter Speed Combo set to unspecified value: ", shooterSpeedCombo);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
