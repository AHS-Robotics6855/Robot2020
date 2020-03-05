/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PneumaticsSubsystem extends SubsystemBase {
  /**
   * Creates a new Pneumatics.
   */
  private Compressor m_compressor;
  private DoubleSolenoid m_solenoidIntake;
  private DoubleSolenoid m_solenoidSpin;

  public PneumaticsSubsystem() {
    m_compressor = new Compressor();
    m_compressor.start();
    m_solenoidIntake = new DoubleSolenoid(0,1);
    m_solenoidSpin = new DoubleSolenoid(2,3);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void intakeOpen(){
    m_solenoidIntake.set(Value.kForward);
  }

  public void intakeClose(){
    m_solenoidIntake.set(Value.kReverse);
  }
  
  public void spinOpen(){
    m_solenoidSpin.set(Value.kForward);
  }

  public void spinClose(){
    m_solenoidSpin.set(Value.kReverse);
  }
}
