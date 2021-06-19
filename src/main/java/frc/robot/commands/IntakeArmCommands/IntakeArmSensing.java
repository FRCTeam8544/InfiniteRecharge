// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.IntakeArmCommands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeArm;

public class IntakeArmSensing extends CommandBase {
  /** Creates a new IntakeArmSensing. */
  IntakeArm m_intakeArm;
  static int commandCount;
  public IntakeArmSensing(IntakeArm intakeArm) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_intakeArm = intakeArm;
    addRequirements(intakeArm);
    commandCount = 0;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    commandCount++;
    //green = 1
    //red = 0
    SmartDashboard.putBoolean("Top Limit Switch: ", m_intakeArm.topArmLimitSwitch.get());
    SmartDashboard.putBoolean("Bottom Limit Switch: ", m_intakeArm.bottomArmLimitSwitch.get());
    SmartDashboard.putNumber("Count: ", commandCount);
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
