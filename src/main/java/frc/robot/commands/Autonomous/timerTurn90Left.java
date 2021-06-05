// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class timerTurn90Left extends CommandBase {
  /** Creates a new timerTurn90Left. */
  public timerTurn90Left() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.m_driveTrain.driveTimer.reset();
    RobotContainer.m_driveTrain.driveTimer.start();
  }
  public static int variable1 = 0;
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    variable1++;
    SmartDashboard.putNumber("tankDrive Speed: ", RobotContainer.m_driveTrain.driveMotor1.get());
    RobotContainer.m_driveTrain.tankDrive(.3, -.3);
    SmartDashboard.putNumber("Timer: ", RobotContainer.m_driveTrain.driveTimer.get());
    SmartDashboard.putString("LeftTurn was: ", "Called");
    SmartDashboard.putNumber("LeftTurn was execueted: ", variable1);


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    SmartDashboard.putString("Drive Turn Command was: ", "Interupted");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //6.94, 1.44
    return (RobotContainer.m_driveTrain.driveTimer.get() > 30);
  }
}
