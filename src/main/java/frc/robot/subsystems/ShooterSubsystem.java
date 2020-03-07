/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


public class ShooterSubsystem extends SubsystemBase {

  private VictorSPX m_top, m_bottom;

  public ShooterSubsystem(){

    m_bottom = new VictorSPX(Constants.SHOOTER_1);
    m_top = new VictorSPX(Constants.SHOOTER_2);
    
  }

  public void shoot()
  {
    m_top.set     (VictorSPXControlMode.PercentOutput, 0.70);
    m_bottom.set  (VictorSPXControlMode.PercentOutput, 0.90);
  }

  public void stop()
  {
    m_top.set     (VictorSPXControlMode.PercentOutput, 0);
    m_bottom.set  (VictorSPXControlMode.PercentOutput, 0);
  }

  @Override
  public void periodic() {
  }

}
