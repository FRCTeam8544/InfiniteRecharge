/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants;
import frc.robot.commands.RapidShoot;
import frc.robot.commands.ShooterSpeed;
import frc.robot.commands.SingleShot;
import edu.wpi.first.wpilibj.Joystick;


//this is where we will create buttons and button triggers 

public class OurHID extends SubsystemBase {
  /**
   * Creates a new OurHID.
   */
  JoystickButton ShooterSpeedCombo1 = null;
  JoystickButton ShooterSpeedCombo2 = null;
  JoystickButton ShooterSpeedCombo3 = null;
  JoystickButton ShooterSpeedCombo4 = null;

  JoystickButton rapidShootButton = null;
  JoystickButton singleShotButton = null;

  Joystick HIDController = null;
  Joystick rightDriverController = null;
  Joystick leftDriverController = null;


  JoystickButton armUp = null;
  JoystickButton armDownRobotUp = null; 
  

  public OurHID() {
    HIDController = new Joystick(Constants.OURHID_HID_CONTROLLER);
    ShooterSpeedCombo1 = new JoystickButton(HIDController, Constants.OUR_HID_SHOOTER_SPEED_COMBO_1);
    ShooterSpeedCombo2 = new JoystickButton(HIDController, Constants.OUR_HID_SHOOTER_SPEED_COMBO_2);
    ShooterSpeedCombo3 = new JoystickButton(HIDController, Constants.OUR_HID_SHOOTER_SPEED_COMBO_3);
    ShooterSpeedCombo4 = new JoystickButton(HIDController, Constants.OUR_HID_SHOOTER_SPEED_COMBO_4);

    //this button will control the piston 
    rapidShootButton = new JoystickButton(HIDController, Constants.OUR_HID_RAPID_SHOOT_BUTTON);
    singleShotButton = new JoystickButton(HIDController, Constants.OUR_HID_SINGLE_SHOT_BUTTON);

    rightDriverController = new Joystick(Constants.OUR_HID_RIGHT_DRIVER_CONTROLLER);
    leftDriverController = new Joystick(Constants.OUR_HID_LEFT_DRIVER_CONTROLLER);


    armUp = new JoystickButton(HIDController, Constants.ARM_UP);
    armDownRobotUp = new JoystickButton(HIDController, Constants.ARM_DOWN_ROBOT_UP);

    
    //
   ShooterSpeedCombo1.whenPressed(new ShooterSpeed(1));
   ShooterSpeedCombo2.whenPressed(new ShooterSpeed(2));
   ShooterSpeedCombo3.whenPressed(new ShooterSpeed(3));
   ShooterSpeedCombo4.whenPressed(new ShooterSpeed(4));
    
    //~maybe change trigger types 
    rapidShootButton.whileHeld(new RapidShoot(true), false);
    rapidShootButton.whenReleased(new RapidShoot(false), false);

    singleShotButton.whenPressed(new SingleShot(true), false);

    armUp.WhileHeld(new )



  } 
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
