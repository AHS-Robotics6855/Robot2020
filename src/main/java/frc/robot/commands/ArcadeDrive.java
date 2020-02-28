package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrainSubsystem;

/**
 *
 */
public class ArcadeDrive extends CommandBase {

    private DriveTrainSubsystem m_drive;

    public ArcadeDrive(DriveTrainSubsystem drive) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        m_drive = drive;
    	addRequirements(m_drive);
    }

    // Called just before this Command runs the first time
    public void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
    	Robot.drive.arcadeDrive(Robot.stick.getRawAxis(Constants.JOYSTICK_X), -Robot.stick.getRawAxis(Constants.JOYSTICK_Y));
    }

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
