// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class feederDrumJoystick extends CommandBase {
  /** Creates a new feederDrumJoystick. */
  public feederDrumJoystick() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_feederDrum);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftStick = RobotContainer.logitechController.getRawAxis(1);
    //RobotContainer.m_feederDrum.setDrumMotorSpeedJoytick(rightStick);
    RobotContainer.m_feederDrum.setDrumMotorSpeedJoytick(leftStick);
    SmartDashboard.putNumber("Feeder Drum Speed: ", RobotContainer.m_feederDrum.drumMotor.getMotorOutputPercent());
    DriverStation.reportError("Feeder Drum Speed: " + RobotContainer.m_feederDrum.drumMotor.getMotorOutputPercent(), true);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
