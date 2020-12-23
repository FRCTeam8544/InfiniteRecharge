/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Shooter.
   */
  DigitalInput shooterSwitch = null;
  
  public Shooter() {
    //constructor for shooter 
  shooterSwitch = new DigitalInput(Constants.SHOOTER_SWITCH);
  
  }

  //method tells when the shooter switch is pressed 
  //switches have 2 states: open and closed; have to figure which is true and which is false; may have to invert switch by rewiring
  public boolean isShooterSwitchClosed(){
    return shooterSwitch.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
