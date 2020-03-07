package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.LimeLightSubsystem;

public class TargetGoal extends CommandBase
{
    protected LimeLightSubsystem m_limeSub;
    protected DriveTrainSubsystem m_drive;
    protected JoystickButton m_exit_button;

    public TargetGoal(LimeLightSubsystem lime, DriveTrainSubsystem drive, JoystickButton exit)
    {
        m_limeSub = lime;
        m_drive = drive;
        m_exit_button = exit;
        addRequirements(m_limeSub, m_drive);
    }

    @Override
    public void initialize() {
        m_limeSub.lightOn();
    }

    public void execute()
    {
        double tx = m_limeSub.getAngleX();
        double ty = m_limeSub.getAngleY();

        double steering_adjust = 0, distance_adjust = 0;

        double max_speed_s = 0.4, min_speed_s = 0.15;
        double max_speed_d = 0.5, min_speed_d = 0.3;

        if(Math.abs(tx) > 0.7)
        {
            //Use min and max turn speeds
            steering_adjust = Math.copySign(MathUtil.clamp(Math.abs(-0.05 * tx), min_speed_s, max_speed_s), -tx);
        }

        if(Math.abs(ty) > 1.5)
        {
            //Use min and max drive speeds
            distance_adjust = Math.copySign(MathUtil.clamp(Math.abs(-0.1 * ty), min_speed_d, max_speed_d), -ty);
            //The farther away the less it turns
            steering_adjust /= MathUtil.clamp(Math.abs(ty), 1, 7);
        }

        double left  = distance_adjust - steering_adjust;
        double right = distance_adjust + steering_adjust;

        m_drive.tankDrive(left, -right);
    }

    public boolean isFinished()
    {
        return !(m_exit_button.get());
    }

    @Override
    public void end(boolean interrupted) {
        m_limeSub.lightOff();
    }
    
    protected void interrupted() { end(true); }


}