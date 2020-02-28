package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class ColorSpinSubsystem extends SubsystemBase {
  //private DifferentialDrive m_drive;
  private VictorSPX spinner;

  public ColorSpinSubsystem() {
    //spinner = new VictorSPX(?)
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcadeDrive(double x, double y) {
    //m_drive.arcadeDrive(-x, -y);
  }

  public void spin()
  {
    //spinner.set(0.5);
  }
}