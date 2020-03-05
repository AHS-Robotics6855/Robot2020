package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.ColorSensorV3;


public class ColorSpinSubsystem extends SubsystemBase {

  private VictorSPX spinner;
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

  public ColorSpinSubsystem() {
    spinner = new VictorSPX(Constants.COLOR_SPIN_MOTOR_ID);
  }

  public void spin()
  {
 //   spinner.set(VictorSPXControlMode.Position, 10);
    spinner.set(VictorSPXControlMode.PercentOutput, 1);
  }
  public void spinOff(){
    spinner.set(VictorSPXControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
  }
  
  //Automation
  public void selectColorG(){
    if(m_colorSensor.getIR() != m_colorSensor.getGreen()){
      spinner.set(VictorSPXControlMode.PercentOutput, 0.5);
    }
  }
  public void selectColorR(){
    if(m_colorSensor.getIR() != m_colorSensor.getRed()){
      spinner.set(VictorSPXControlMode.PercentOutput, 0.5);
    }
  }
  public void selectColorY(){
    if(m_colorSensor.getIR() >= 560 && m_colorSensor.getIR() <= 590){
      spinner.set(VictorSPXControlMode.PercentOutput, 0.5);
    }
  }
  public void selectColorB(){
    if(m_colorSensor.getIR() != m_colorSensor.getBlue()){
      spinner.set(VictorSPXControlMode.PercentOutput, 0.5);
    }
  }

}