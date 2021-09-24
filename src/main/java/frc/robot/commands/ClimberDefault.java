package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Climber;
import frc.robot.RobotContainer;

public class ClimberDefault extends CommandBase {
    Climber m_climber;
   


    public ClimberDefault(Climber climber) {
        m_climber = climber;
        addRequirements(m_climber);
       
    }

    @Override
    public void initialize() {}
 
    @Override
    public void execute() {
        // HIDController joystick
        // To Do: Check whether getRawAxis(3) denotes right joystick vertical axis
        double rightVerticalPosition = RobotContainer.HIDController.getRawAxis(3);
        m_climber.setMotorSpeed(/*m_climber.rampRate*/rightVerticalPosition);

    }

    @Override
    public void end(boolean interrupted) {
        m_climber.stopMotor();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
