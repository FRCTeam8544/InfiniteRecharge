/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

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
    public static final int DRIVER_CONTROLLER = 0;

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

    //port number on RoboRIO's DIO for shooter switch
	public static final int SHOOTER_SWITCH = 0;
}
