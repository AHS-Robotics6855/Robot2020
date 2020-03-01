package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.LimeLightSubsystem;

public class TargetGoal extends CommandBase
{
    private LimeLightSubsystem m_limeSub;
    private DriveTrainSubsystem m_drive;
    private JoystickButton m_exit_button;

    public TargetGoal(LimeLightSubsystem lime, DriveTrainSubsystem drive, JoystickButton exit)
    {
        m_limeSub = lime;
        m_drive = drive;
        m_exit_button = exit;
        addRequirements(m_limeSub, m_drive);
    }

    public void initialize() { }

    public double sidedClamp(double value, double min, double max)
    {
        if(value < 0)
            return MathUtil.clamp(value, -min, -max);
        if(value > 0)
            return MathUtil.clamp(value, min, max);
        return 0;
    }

    public void execute()
    {
        double steering_adjust = -0.05 * m_limeSub.getAngleX();
        double distance_adjust = -0.05 * m_limeSub.getAngleY();

        double max_speed_s = 0.3;
        double min_speed_s = 0.15;

        double max_speed_d = 0.5;
        double min_speed_d = 0.15;

        steering_adjust = sidedClamp(steering_adjust, min_speed_s, max_speed_s);
        distance_adjust = sidedClamp(distance_adjust, min_speed_d, max_speed_d);

        steering_adjust /= MathUtil.clamp(Math.abs(m_limeSub.getAngleY()), 1, 7);

        //System.out.println(MathUtil.clamp(Math.abs(m_limeSub.getAngleY()), 2, 10));
        
        if(Math.abs(steering_adjust) > 0)
             m_drive.tankDrive(-steering_adjust+distance_adjust, -steering_adjust-distance_adjust);
    }

    public void executeq()
    {
        float left_command = 0.0f, right_command = 0.0f;

        float KpAim = -0.045f;
        float KpDistance = -0.045f;
        float min_aim_command = 0.05f;

        float tx = (float)m_limeSub.getAngleX();
        float ty = (float)m_limeSub.getAngleY();

        float heading_error = -tx;
        float distance_error = -ty;
        float steering_adjust = 0.0f;

        if(tx > 1.0)
        {
            steering_adjust = KpAim*heading_error - min_aim_command;
        }
        else if(tx < 1.0)
        {
            steering_adjust = KpAim*heading_error + min_aim_command;
        }

        float distance_adjust = KpDistance * distance_error;

        left_command += steering_adjust + distance_adjust;
        right_command -= steering_adjust + distance_adjust;

        m_drive.tankDrive(-left_command, -right_command);

    }

    public boolean isFinished()
    {
        return !(m_exit_button.get());
    }

    protected void end() { }
    
    protected void interrupted() { }


}