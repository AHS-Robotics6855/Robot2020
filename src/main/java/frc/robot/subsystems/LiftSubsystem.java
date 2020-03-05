/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LiftSubsystem extends SubsystemBase {
  /**
   * Creates a new LiftSubsystem.
   */
  private VictorSPX m_extend;
  private CANSparkMax m_winch;
  private DigitalInput m_limit;

  public LiftSubsystem() {
    m_extend = new VictorSPX(Constants.LIFT);
    m_winch = new CANSparkMax(Constants.WINCH, MotorType.kBrushless);
    m_limit = new DigitalInput(Constants.LIMIT);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void extUp(){
    if(m_limit.get()){
      m_extend.set(VictorSPXControlMode.PercentOutput, 0.4);
    }
    else
    {
      extStop();
    }
    SmartDashboard.putBoolean("Limit", m_limit.get());
  }

  public void extBack(){
    m_extend.set(VictorSPXControlMode.PercentOutput, -0.4);
  }
  public void extStop(){
    m_extend.set(VictorSPXControlMode.PercentOutput, 0);
  }
  
  public void winchWind(){
    m_winch.set(-0.65);
  }
  public void winchWindOff(){
    m_winch.set(0);
  }

}
