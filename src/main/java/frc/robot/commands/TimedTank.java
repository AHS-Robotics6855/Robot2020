/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class TimedTank extends CommandBase {
  /**
   * Creates a new DriveStraightForXatYCommand.
   */
  protected double powerL;
  protected double powerR;
  protected long time;
  protected long endtime;
  private DriveTrainSubsystem m_driveSyst;
  // public DriveStraightForXatYCommand() {
  //   // Use addRequirements() here to declare subsystem dependencies.
  // }

  // Called when the command is initially scheduled.
  public TimedTank(DriveTrainSubsystem bacon, double powerLe, double powerRi, long timeinMills) {
    this.powerL = powerLe;
    this.powerR = powerRi;
    this.time = timeinMills;
    m_driveSyst = bacon;
    addRequirements(bacon); 
  }

  @Override
  public void initialize() {
    long startTime = System.currentTimeMillis();
    endtime = startTime + this.time;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveSyst.tankDrive(powerL, -powerR);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveSyst.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return System.currentTimeMillis() >= endtime;
  }
}
