// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DrumCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drum;

public class AutoDrumSpeed extends CommandBase {
  /** Creates a new AutoDrumSpeed. */
  Drum m_drum;
  double percentPower;
  double waitTime;
  Timer drumTimer;

  public AutoDrumSpeed(Drum drum, double speed, double timeToWait) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_drum = drum;
    percentPower = speed;
    waitTime = timeToWait;
    drumTimer = new Timer();
    addRequirements(m_drum);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //reseting timer
    drumTimer.reset();
    //starting timer which will measure the amount of time in seconds before the command will begin 
    drumTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putString("Auto Drum was: ", "Executed");
    
    /*This tests the value of the timer (in seconds) against a variable (whose value is set by us in the parameters of the command) to see 
    if enough time (in seconds) has passed to start the drum motor.
    The reason I have set it up this way is because I plan to use this command in a Parallel Deadline Group or Parallel Race Group (I have not
    determined which yet) in order to schedule both the autonomous shooter command and this command at the same time so they both will execute.
    This timer should keep the drum motor from turning on at the same time as the shooter wheel motors. */
    //Link to command group documentation: https://docs.wpilib.org/en/stable/docs/software/commandbased/command-groups.html?highlight=command%20group 
    if (drumTimer.get() >= waitTime){
      m_drum.setDrumSpeed(percentPower);
    }
    else{
      m_drum.setDrumSpeed(0);
    
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drum.drumMotorOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
