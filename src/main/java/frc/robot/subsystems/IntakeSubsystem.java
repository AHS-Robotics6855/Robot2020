/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


public class IntakeSubsystem extends SubsystemBase {

  private VictorSPX m_back, m_front;

  public IntakeSubsystem() {
    m_back = new VictorSPX(9);
    m_front = new VictorSPX(7);
  }

  public void spinBackward()
  {
    m_back.set  (VictorSPXControlMode.PercentOutput,  1);
    m_front.set (VictorSPXControlMode.PercentOutput, -1);
  }

  public void spinForward()
  {
    m_back.set  (VictorSPXControlMode.PercentOutput, -1);
    m_front.set (VictorSPXControlMode.PercentOutput,  1);
  }

  public void stop()
  {
    m_back.set(VictorSPXControlMode.PercentOutput, 0);
    m_front.set(VictorSPXControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
  }
}
