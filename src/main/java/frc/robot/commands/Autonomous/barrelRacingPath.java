// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class barrelRacingPath extends SequentialCommandGroup {
  /** Creates a new barrelRacingPath. */
  public barrelRacingPath(DriveTrain drivetrain) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new driveDistance(.5, 144 ),
      new timerTurn90Right(),
      new driveDistance(.5, 54 ),
      new timerTurn90Right(),
      new driveDistance(.5, 60),
      new timerTurn90Right(),
      new driveDistance(.5, 54),
      new timerTurn90Right(),
      new driveDistance(.5, 150),
      new timerTurn90Left(),
      new driveDistance(.5, 60),
      new timerTurn90Left(),
      new driveDistance(.5, 60),
      new timerTurn90Left(),
      new driveDistance(.5, 120),
      new timerTurn90Left(),
      new driveDistance(.5, 144),
      new timerTurn90Left(),
      new driveDistance(.5, 60),
      new timerTurn90Left(),
      new driveDistance(.5, 300)
    );
  }
}
