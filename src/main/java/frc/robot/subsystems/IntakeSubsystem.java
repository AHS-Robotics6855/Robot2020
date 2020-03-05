/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


public class IntakeSubsystem extends SubsystemBase {

  private VictorSPX m_back, m_front, m_extend;

  public IntakeSubsystem() {
    m_back = new VictorSPX(Constants.INTAKE_1);
    m_front = new VictorSPX(Constants.INTAKE_2);
    m_extend = new VictorSPX(Constants.INTAKE_ROLLER);
  }

  public void spinBackward()
  {
    m_back.set  (VictorSPXControlMode.PercentOutput,  0.85);
    m_front.set (VictorSPXControlMode.PercentOutput, -0.85);
    m_extend.set(VictorSPXControlMode.PercentOutput,  0.4);
  }
  
  public void spinForward()
  {
    m_back.set  (VictorSPXControlMode.PercentOutput, -0.85);
    m_front.set (VictorSPXControlMode.PercentOutput,  0.85);
    m_extend.set(VictorSPXControlMode.PercentOutput,  -0.4);
  }

  public void stop()
  {
    m_back.set  (VictorSPXControlMode.PercentOutput, 0);
    m_front.set (VictorSPXControlMode.PercentOutput, 0);
    m_extend.set(VictorSPXControlMode.PercentOutput,  0);
  }
  
  @Override
  public void periodic() {
  }
}
