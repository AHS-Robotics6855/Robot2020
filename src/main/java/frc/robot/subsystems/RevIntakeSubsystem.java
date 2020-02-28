/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class RevIntakeSubsystem extends SubsystemBase {
  /**
   * Creates a new RevIntakeSubsystem.
   * 
   */
  public VictorSPX back;
  public VictorSPX front;

  public RevIntakeSubsystem() {
    back = new VictorSPX(9);
    front = new VictorSPX(7);
    //setDefaultCommand(new RevIntakeCommand(Robot.rev));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //setDefaultCommand(new RevIntakeCommand(Robot.rev));
  }
}
