// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.EncoderType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //drivetrain
	public static final int DRIVETRAIN_FRONT_LEFT_DRIVE_MOTOR_ID = 5;
    public static final MotorType DRIVETRAIN_FRONT_LEFT_DRIVE_MOTOR_MOTORTYPE = MotorType.kBrushless;
    
	public static final int DRIVETRAIN_BACK_LEFT_DRIVE_MOTOR_ID = 6;
    public static final MotorType DRIVETRAIN_BACK_LEFT_DRIVE_MOTOR_MOTORTYPE = MotorType.kBrushless;
    
	public static final int DRIVETRAIN_FRONT_RIGHt_DRIVE_MOTOR_ID = 3;
    public static final MotorType DRIVETRAIN_FRONT_RIGHT_DRIVE_MOTOR_MOTORTYPE = MotorType.kBrushless;
    
	public static final int DRIVETRAIN_BACK_RIGHT_DRIVE_MOTOR_ID = 4;
    public static final MotorType DRIVETRAIN_BACK_RIGHT_DRIVE_MOTOR_MOTORTYPE = MotorType.kBrushless;
    
	public static final boolean DRIVETRAIN_FRONT_LEFT_DRIVE_MOTOR_INVERSION = false;
    public static final boolean DRIVETRAIN_FRONT_RIGHT_DRIVE_MOTOR_INVERSION = true;

    public static final EncoderType DRIVETRAIN_FRONT_LEFT_ENCODER_ENCODERTYPE = EncoderType.kHallSensor;
    public static final int DRIVETRAIN_FRONT_LEFT_ENCODER_CPR = 42;
    
	public static final EncoderType DRIVETRAIN_BACK_LEFT_ENCODER_ENCODERTYPE = EncoderType.kHallSensor;
    public static final int DRIVETRAIN_BACK_LEFT_ENCODER_CPR = 42;
    
	public static final EncoderType DRIVETRAIN_FRONT_RIGHT_ENCODER_ENCODERTYPE = EncoderType.kHallSensor;
    public static final int DRIVETRAIN_FRONT_RIGHT_ENCODER_CPR = 42;
    
	public static final EncoderType DRIVETRAIN_BACK_RIGHT_ENCODER_ENCODERTYPE = EncoderType.kHallSensor;
	public static final int DRIVETRAIN_BACK_RIGHT_ENCODER_CPR = 42;

    public static final double DRIVETRAIN_CLIP_VALUE = .5;

    //drum
    public static final int DRUM_DRUM_MOTOR_ID = 3;

    //intakeArm
    public static final int INTAKEARM_ARM_MOTOR_ID = 1;
            //channels = 0 or 1 
    public static final int INTAKEARM_TOP_ARM_LIMIT_SWITCH_CHANNEL = 0;
    public static final int INTAKEARM_BOTTOM_ARM_LIMIT_SWITCH_CHANNEL = 1;
    
    //shooter
	public static final int SHOOTER_TOP_SHOOTER_WHEEL_ID = 1;
    public static final MotorType SHOOTER_TOP_SHOOTER_WHEEL_MOTORTYPE = MotorType.kBrushless;
    
	public static final int SHOOTER_BOTTOM_SHOOTER_WHEEL_ID = 2;
    public static final MotorType SHOOTER_BOTTOM_SHOOTER_WHEEL_MOTORTYPE = MotorType.kBrushless;
    
	public static final boolean SHOOTER_TOP_SHOOTER_WHEEL_INVERSION = false;
    public static final boolean SHOOTER_BOTTOM_SHOOTER_WHEEL_INVERSION = true;
    
    //robotcontainer
	public static final int ROBOTCONTAINER_LEFT_DRIVE_CONTROLLER_PORT = 0;
    public static final int ROBOTCONTAINER_RIGHT_DRIVE_CONTROLLER_PORT = 1;
    public static final int ROBOTCONTAINER_HID_CONTROLLER_PORT = 2;
        //logitech controller button numbers
    public static final int LOGITECH_BUTTON_A = 2;
    public static final int LOGITECH_BUTTON_B = 3;
    public static final int LOGITECH_BUTTON_X = 1;
    public static final int LOGITECH_BUTTON_Y = 4;
    public static final int LOGITECH_BUTTON_LEFT_THUMB = 5;
    public static final int LOGITECH_BUTTON_LEFT_TRIGGER = 7;
    public static final int LOGITECH_BUTTON_RIGHT_TRIGGER = 8;
        //buttons on HIDController
            //shooter buttons
	public static final int ROBOTCONTAINER_BUTTON_NUMBER_B = LOGITECH_BUTTON_B;
	public static final int ROBOTCONTAINER_BUTTON_NUMBER_X = LOGITECH_BUTTON_X;
	public static final int ROBOTCONTAINER_BUTTON_NUMBER_Y = LOGITECH_BUTTON_Y;
    public static final int ROBOTCONTAINER_BUTTON_NUMBER_A = LOGITECH_BUTTON_A;
            //intake arm buttons
	public static final int ROBOTCONTAINER_BUTTON_LEFT_TRIGGER = LOGITECH_BUTTON_LEFT_TRIGGER;
    public static final int ROBOTCONTAINER_BUTTON_RIGHT_TRIGGER = LOGITECH_BUTTON_RIGHT_TRIGGER;
            //drum pulse buttons
	public static final int ROBOTCONTAINER_BUTTON_LEFT_THUMB = LOGITECH_BUTTON_LEFT_THUMB;
	}
