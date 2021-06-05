// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DriveTrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class slalomPath extends SequentialCommandGroup {
  /** Creates a new slalomPath. */
  public slalomPath() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new driveDistance(-.3, 54),
      new WaitCommand(2),
      new encoderTurn90(.3, -.3, -9.7),
      new WaitCommand(2),
      new driveDistance(-.3, 65),
      new WaitCommand(2),
      new encoderTurn90(-.3, .3, 9.75),
      new WaitCommand(2),
      new driveDistance(-.3, 168),
      new WaitCommand(2),
      new encoderTurn90(-.3, .3, 9.6),
      new WaitCommand(2),
      new driveDistance(-.3, 60),
      new WaitCommand(2),
      new encoderTurn90(.3, -.3, -9.7),
      new WaitCommand(2),
      new driveDistance(-.3, 60),
      new WaitCommand(2),
      new encoderTurn90(.3, -.3, -9.7),
      new WaitCommand(2)
    );
  }
}
