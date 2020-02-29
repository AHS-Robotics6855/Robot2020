package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


public class ColorSpinSubsystem extends SubsystemBase {

  private VictorSPX spinner;

  public ColorSpinSubsystem() {
    //TODO
    //spinner = new VictorSPX(?)
  }

  public void spin()
  {
    spinner.set(VictorSPXControlMode.PercentOutput, 0.5);
  }

  @Override
  public void periodic() {
  }

}