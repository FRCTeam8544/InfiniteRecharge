/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.revrobotics.EncoderType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.SPI.Port;



/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //constants is the new RobotMap.java library (they are the same thing )

    

	//port #s for SparkMAX motor controllers
	public static final int SHOOTER_TOP_WHEEL_SPARK_MAX = 1;
	public static final int SHOOTER_BOTTOM_WHEEL_SPARK_MAX = 2;
	
	//motortype for SparkMax (2nd parameter)
	public static final MotorType MOTOR_TYPE_SHOOTER_TOP_WHEEL_SPARK_MAX = MotorType.kBrushless;
    public static final MotorType MOTOR_TYPE_SHOOTER_BOTTOM_WHEEL_SPARK_MAX = MotorType.kBrushless;

	//shooter wheels speed combo #1
	public static final double SHOOTER_TOP_WHEEL_SPEED_1 = .7;
	public static final double SHOOTER_BOTTOM_WHEEL_SPEED_1 = .7;

	//shooter wheels speed combo #2
	public static final double SHOOTER_TOP_WHEEL_SPEED_2 = .7;
	public static final double SHOOTER_BOTTOM_WHEEL_SPEED_2 = .7;

	//shooter wheels speed combo #3
	public static final double SHOOTER_TOP_WHEEL_SPEED_3 = .7;
	public static final double SHOOTER_BOTTOM_WHEEL_SPEED_3 = .7;

	//shooter wheels speed combo #4
	public static final double SHOOTER_TOP_WHEEL_SPEED_4 = .7;
	public static final double SHOOTER_BOTTOM_WHEEL_SPEED_4 = .7;

	//Xbox Controller port #
	public static final int OURHID_HID_CONTROLLER = 0;

	//~THESE NUMBERS DO NOT CORRESPOND YET!!!
	public static final int LOGITECH_CONTROLLER_BUTTON_A = 1;
	public static final int LOGITECH_CONTROLLER_BUTTON_B = 2;
	public static final int LOGITECH_CONTROLLER_BUTTON_X = 3;
	public static final int LOGITECH_CONTROLLER_BUTTON_Y = 4;
	public static final int LOGITECH_CONTROLLER_BUTTON_RIGHT_BACK = 6;
	public static final int LOGITECH_CONTROLLER_BUTTON_LEFT_BACK = 5;
	public static final int LOGITECH_CONTROLLER_JOYSTICK_LEFT = 1;
	public static final int LOGITECH_CONTROLLER_JOYSTICK_RIGHT = 3;

	//change buttons here (not above)
	public static final int OUR_HID_SHOOTER_SPEED_COMBO_1 = LOGITECH_CONTROLLER_BUTTON_A;
	public static final int OUR_HID_SHOOTER_SPEED_COMBO_2 = LOGITECH_CONTROLLER_BUTTON_B;
	public static final int OUR_HID_SHOOTER_SPEED_COMBO_3 = LOGITECH_CONTROLLER_BUTTON_X;
	public static final int OUR_HID_SHOOTER_SPEED_COMBO_4 = LOGITECH_CONTROLLER_BUTTON_Y;

	//piston buttons
	public static final int OUR_HID_RAPID_SHOOT_BUTTON = LOGITECH_CONTROLLER_BUTTON_RIGHT_BACK;
	public static final int OUR_HID_SINGLE_SHOT_BUTTON = LOGITECH_CONTROLLER_BUTTON_LEFT_BACK;


	//CAN ID
	public static final int SHOOTER_PISTON_POSITION = 0;
	//forward piston port
	public static final int SHOOTER_SHOOT_PISTON_FORWARD = 0;
	//reverse piston port
	public static final int SHOOTER_SHOOT_PISTON_REVERSE = 0;
	
	//piston positions 
	public static final Value SHOOTER_PISTON_POSITION_REVERSE = Value.kReverse;
	public static final Value SHOOTER_PISTON_POSITION_FORWARD = Value.kForward;

	public static final int DRIVETRAIN_DRIVE_MOTOR_1 = 1;
	public static final int DRIVETRAIN_DRIVE_MOTOR_2 = 2;
	public static final int DRIVETRAIN_DRIVE_MOTOR_3 = 3;
	public static final int DRIVETRAIN_DRIVE_MOTOR_4 = 4;

	public static final boolean DRIVETRAIN_DRIVE_MOTOR_1_INVERSION = false;
	public static final boolean DRIVETRAIN_DRIVE_MOTOR_2_INVERSION = true;

	public static final int OURHID_RIGHT_DRIVER_CONTROLLER_AXIS = LOGITECH_CONTROLLER_JOYSTICK_LEFT;
	public static final int OURHID_LEFT_DRIVER_CONTROLLER_AXIS = LOGITECH_CONTROLLER_JOYSTICK_RIGHT;

	public static final ControlMode ROBOT_DRIVE_MOTOR_1_CONTROL_MODE = ControlMode.PercentOutput;
	public static final ControlMode ROBOT_DRIVE_MOTOR_2_CONTROL_MODE = ControlMode.PercentOutput;
	public static final ControlMode ROBOT_DRIVE_MOTOR_3_CONTROL_MODE = ControlMode.Follower;
	public static final ControlMode ROBOT_DRIVE_MOTOR_4_CONTROL_MODE = ControlMode.Follower;

	public static final MotorType DRIVETRAIN_DRIVE_MOTOR_1_MOTOR_TYPE = MotorType.kBrushless;
	public static final MotorType DRIVETRAIN_DRIVE_MOTOR_2_MOTOR_TYPE = MotorType.kBrushless;
	public static final MotorType DRIVETRAIN_DRIVE_MOTOR_3_MOTOR_TYPE = MotorType.kBrushless;
	public static final MotorType DRIVETRAIN_DRIVE_MOTOR_4_MOTOR_TYPE = MotorType.kBrushless;

	public static final EncoderType ENCODERS_DRIVE_ENCODER_1_SENSOR_TYPE = EncoderType.kQuadrature;
	public static final EncoderType ENCODERS_DRIVE_ENCODER_2_SENSOR_TYPE = EncoderType.kQuadrature;
	public static final EncoderType ENCODERS_DRIVE_ENCODER_3_SENSOR_TYPE = EncoderType.kQuadrature;
	public static final EncoderType ENCODERS_DRIVE_ENCODER_4_SENSOR_TYPE = EncoderType.kQuadrature;

	public static final int ENCODERS_DRIVE_ENCODER_1_CPR = 90;
	public static final int ENCODERS_DRIVE_ENCODER_2_CPR = 90;
	public static final int ENCODERS_DRIVE_ENCODER_3_CPR = 90;
	public static final int ENCODERS_DRIVE_ENCODER_4_CPR = 90;


	public static final EncoderType ENCODERS_SHOOTER_ENCODER_1_SENSOR_TYPE = EncoderType.kQuadrature;
	public static final EncoderType ENCODERS_SHOOTER_ENCODER_2_SENSOR_TYPE = EncoderType.kQuadrature;

	public static final int ENCODERS_SHOOTER_ENCODER_1_CPR = 90;
	public static final int ENCODERS_SHOOTER_ENCODER_2_CPR = 90;
	
	
	public static final Port NAVX_GYRO_PORT = Port.kMXP;
	public static final byte NAVX_GYRO_UPDATE_RATE = 50;

	public static final boolean NAVX_GYRO_ENABLE_LOGGING = true;



	
	

	
	
	
	
	


	


	
	



	





	

}
