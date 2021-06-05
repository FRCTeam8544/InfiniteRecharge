// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import net.thefletcher.revrobotics.enums.MotorType;

import edu.wpi.first.wpilibj.SPI.Port;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

	//driveTrain
	public static final int DRIVETRAIN_DRIVE_MOTOR_1 = 3;
	public static final int DRIVETRAIN_DRIVE_MOTOR_3 = 4;
	public static final MotorType DRIVETRAIN_DRIVE_MOTOR_1_TYPE = MotorType.kBrushless;
	public static final MotorType DRIVETRAIN_DRIVE_MOTOR_3_TYPE = MotorType.kBrushless;
	public static final int DRIVETRAIN_DRIVE_MOTOR_2 = 5;
	public static final int DRIVETRAIN_DRIVE_MOTOR_4 = 6;
	public static final MotorType DRIVETRAIN_DRIVE_MOTOR_2_TYPE = MotorType.kBrushless;
	public static final MotorType DRIVETRAIN_DRIVE_MOTOR_4_TYPE = MotorType.kBrushless;
	public static final boolean DRIVETRAIN_DRIVE_MOTOR_1_INVERSION = false;
	public static final boolean DRIVETRAIN_DRIVE_MOTOR_2_INVERSION = false;
	public static final int DRIVETRAIN_LEFT_JOYSTICK_CONTROLLER = 0;
	public static final int DRIVETRAIN_RIGHT_JOYSTICK_CONTROLLER = 1;


	public static final Port NAVX_GYRO_PORT = null;
	public static final byte NAVX_GYRO_UPDATE_RATE = 0;
	public static final boolean NAVX_GYRO_ENABLE_LOGGING = false;
	
	public static final double CLIPVALUE = .62;
}
