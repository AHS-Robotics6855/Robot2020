package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.commands.ArcadeDrive;

public class DriveTrainSubsystem extends SubsystemBase{
    DifferentialDrive drivesystem;
    SpeedController m_left, m_right;
    
    private CANSparkMax left1;
    private CANSparkMax right1;
    private CANSparkMax left2;
    private CANSparkMax right2;

    public DriveTrainSubsystem(){
        left1 = new CANSparkMax(Constants.DRIVE_Motor_ID, MotorType.kBrushless);
		left2 = new CANSparkMax(Constants.DRIVE_Motor_ID2, MotorType.kBrushless);
		right1= new CANSparkMax(Constants.DRIVE_Motor_ID3, MotorType.kBrushless);		
        right2 = new CANSparkMax(Constants.DRIVE_Motor_ID4, MotorType.kBrushless);
        
        left2.follow(left1);
        right2.follow(right1);
        
        left2.setInverted(true);
        right2.setInverted(true);

        //setDefaultCommand(new ArcadeDrive());


		//m_left = new SpeedControllerGroup(m_leftMotor, m_leftMotor2);
		//m_right = new SpeedControllerGroup(m_rightMotor, m_rightMotor2);

		//m_drive = new DifferentialDrive(m_left, m_right);
        drivesystem = new DifferentialDrive(left1, right1);
        drivesystem.setRightSideInverted(false);
    }
    public void arcadeDrive(double x, double y)
	{
		drivesystem.arcadeDrive(x*0.5, y*0.75);
	}

    public void periodic() {
        // Set the default command for a subsystem here.
    }
}