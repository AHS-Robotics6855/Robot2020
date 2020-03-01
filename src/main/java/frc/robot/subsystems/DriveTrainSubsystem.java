package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants;


public class DriveTrainSubsystem extends SubsystemBase{
    
    private DifferentialDrive m_drivesystem;
    private CANSparkMax m_leftFront, m_leftBack, m_rightFront, m_rightBack;
    //private boolean m_auto = false;

    public DriveTrainSubsystem(){
        m_leftFront  = new CANSparkMax(Constants.DRIVE_Motor_ID,  MotorType.kBrushless);
		m_leftBack   = new CANSparkMax(Constants.DRIVE_Motor_ID2, MotorType.kBrushless);
		m_rightFront = new CANSparkMax(Constants.DRIVE_Motor_ID3, MotorType.kBrushless);		
        m_rightBack  = new CANSparkMax(Constants.DRIVE_Motor_ID4, MotorType.kBrushless);
        
        m_leftBack.follow(m_leftFront);
        m_rightBack.follow(m_rightFront);
        
        m_leftBack.setInverted(true);
        m_rightBack.setInverted(true);

        m_drivesystem = new DifferentialDrive(m_leftFront, m_rightFront);
        m_drivesystem.setRightSideInverted(false);
    }
    public void arcadeDrive(double x, double y)
	{
		m_drivesystem.arcadeDrive(x*0.5, y*0.75);
    }
    
    public void tankDrive(double left, double right)
    {
        m_drivesystem.tankDrive(left, right);
    }

    public void periodic() { }

}