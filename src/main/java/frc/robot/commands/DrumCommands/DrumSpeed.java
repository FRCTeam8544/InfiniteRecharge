// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DrumCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drum;

public class DrumSpeed extends CommandBase {
  /** Creates a new DrumSpeed. */
  Drum m_Drum;

  public DrumSpeed(Drum drum) {
    m_Drum = drum;
    addRequirements(m_Drum);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   double drumSpeed = RobotContainer.HIDController.getRawAxis(0);
    m_Drum.setDrumSpeed(drumSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Drum.drumMotorOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
