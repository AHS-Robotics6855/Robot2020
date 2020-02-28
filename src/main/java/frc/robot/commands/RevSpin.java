/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.RevIntakeSubsystem;

public class RevSpin extends CommandBase {
  /**
   * Creates a new RevSpin.
   */

  RevIntakeSubsystem rev_1;
  int direction = 1;

  public RevSpin(RevIntakeSubsystem rev, int dir) {
    // Use addRequirements() here to declare subsystem dependencies.
    rev_1 = rev;
    addRequirements(rev);
    direction = dir;
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    rev_1.back.set(VictorSPXControlMode.PercentOutput, 1*direction);
    rev_1.front.set(VictorSPXControlMode.PercentOutput, -1*direction);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
