package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrainSubsystem;


public class ArcadeDrive extends CommandBase {

    private DriveTrainSubsystem m_drive;
    private Joystick m_stick;

    public ArcadeDrive(DriveTrainSubsystem drive, Joystick stick) {
        m_drive = drive;
        m_stick = stick;
    	addRequirements(m_drive);
    }

    // Called just before this Command runs the first time
    public void initialize() { }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
        m_drive.arcadeDrive(m_stick.getRawAxis(Constants.JOYSTICK_X), -m_stick.getRawAxis(Constants.JOYSTICK_Y));
        System.out.print("b");
    }

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() { }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() { 
        System.out.print("a");
    }

}
