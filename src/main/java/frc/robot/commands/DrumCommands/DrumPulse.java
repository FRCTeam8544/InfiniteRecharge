// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DrumCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drum;

public class DrumPulse extends CommandBase {
  /** Creates a new DrumPulse. */
  Drum m_drum;
  Timer m_timer;

  public DrumPulse(Drum Drum) {
    m_drum = Drum;
    addRequirements(m_drum);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.reset();
    m_timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drum.setDrumSpeed(.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drum.drumMotorOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (m_timer.get() > 1);
  }
}
