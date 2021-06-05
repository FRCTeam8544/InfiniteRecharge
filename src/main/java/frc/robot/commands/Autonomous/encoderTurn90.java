// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class encoderTurn90 extends CommandBase {
  /** Creates a new encoderTurn90. */
  double m_rightTurnSpeed, m_leftTurnSpeed;
  double currentRM;
  double m_endRM;
  static int m_count = 0;
  static double m_encoderValueSim = 0;
  public encoderTurn90(double rightSpeed, double leftSpeed, double endRM) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_rightTurnSpeed = rightSpeed;
    m_leftTurnSpeed = leftSpeed;
    
    addRequirements(RobotContainer.m_driveTrain);
    m_endRM = endRM;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_driveTrain.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  
    currentRM = RobotContainer.m_driveTrain.driveEncoder1.getPosition();
    
    

    RobotContainer.m_driveTrain.tankDrive(m_leftTurnSpeed, m_rightTurnSpeed);
    SmartDashboard.putNumber("RM: ", currentRM);
    SmartDashboard.putNumber("Increment: ", m_encoderValueSim);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_driveTrain.tankDrive(0, 0);
    m_encoderValueSim = 0;
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //-9.78
    //9.76
    SmartDashboard.putString("Command: ", "Finished");
   if (m_endRM > 0){
      return (currentRM > m_endRM);
    }
  else {
    return (currentRM < m_endRM);
    }
  };
}
