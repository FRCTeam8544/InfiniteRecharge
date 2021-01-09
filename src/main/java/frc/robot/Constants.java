/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;


import edu.wpi.first.wpilibj.DoubleSolenoid.Value;



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

    //these are the assigned ports for the VictorSP motors; change the port numbers here
    
    //This is port number for the Joystick; port number is found on the laptop in the Driverstation software
    public static final int DRIVER_CONTROLLER = 1;

    //
	//public static final String DRIVER_CONTROLLER_MOVE_AXIS = null;
    //public static final String DRIVER_CONTROLLER_ROTATE_AXIS = null;
    
    //change values for our robot; values are specific to joysticks
	public static final int DRIVER_CONTROLLER_LEFT_MOVE_AXIS = 1;
	public static final int DRIVER_CONTROLLER_RIGHT_MOVE_AXIS = 2;
    
    
	public static final int DRIVETRAIN_RIGHT_BACK_VICTORSPX = 0;
	public static final int DRIVETRAIN_RIGHT_FRONT_VICTORSPX = 1;
	public static final int DRIVETRAIN_LEFT_BACK_VICTORSPX = 2;
	public static final int DRIVETRAIN_LEFT_FRONT_VICTORSPX = 3;

	//port #s for SparkMAX motor controllers
	public static final int SHOOTER_TOP_WHEEL_SPARK_MAX = 0;
	public static final int SHOOTER_BOTTOM_WHEEL_SPARK_MAX = 1;
	
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
	public static final int OURHID_HID_CONTROLLER = 1;

	//~THESE NUMBERS DO NOT CORRESPOND YET!!!
	public static final int LOGITECH_CONTROLLER_BUTTON_A = 1;
	public static final int LOGITECH_CONTROLLER_BUTTON_B = 2;
	public static final int LOGITECH_CONTROLLER_BUTTON_X = 3;
	public static final int LOGITECH_CONTROLLER_BUTTON_Y = 4;
	public static final int LOGITECH_CONTROLLER_BUTTON_RIGHT_BACK = 6;
	public static final int LOGITECH_CONTROLLER_BUTTON_LEFT_BACK = 5;

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

	//driver joysticks
	public static final int OUR_HID_RIGHT_DRIVER_CONTROLLER = 0;
	public static final int OUR_HID_LEFT_DRIVER_CONTROLLER = 0;

	
	
	// Winch motors for climber
	public static final int WINCH_MOTOR = 3;

	public static final MotorType WINCH_MOTOR_TYPE = MotorType.kBrushless;

	
	public static final int ARM_UP = 0;

	public static final int ARM_DOWN_ROBOT_UP = 0;

	public static final int LOGITECH_CONTROLLER_BUTTON_START = 10;
	public static final int LOGITECH_CONTROLLER_BUTTON_BACK = 9;



	


	
	



	





	

}
