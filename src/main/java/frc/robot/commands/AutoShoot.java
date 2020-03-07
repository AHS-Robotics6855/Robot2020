/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LimeLightSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class AutoShoot extends CommandBase {
  /**
   * Creates a new AutoShoot.ur
   */
  protected ShooterSubsystem m_shoot;
  protected IntakeSubsystem m_intake;
  protected LimeLightSubsystem m_lime;
  protected long m_time;
  protected long m_endtime;
  private long m_rev_time = 3000;
  protected long m_startTime;
  protected boolean error = false;

  public AutoShoot(ShooterSubsystem shoot, IntakeSubsystem intake, LimeLightSubsystem lime, long time) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.m_shoot = shoot;
    this.m_intake = intake;
    this.m_time = time;
    this.m_lime = lime;
    addRequirements(shoot, intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_startTime = System.currentTimeMillis();
    m_endtime = m_startTime + this.m_time;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // if(System.currentTimeMillis() <= startTime + m_back){
    //   m_intake.spinBackward();
    // }
    // m_lime.lightOn();
    m_shoot.shoot();
    if(System.currentTimeMillis() > m_startTime + m_rev_time){
      m_intake.spinForward();
      // if(m_lime.getArea() < 0.5)
      // {
      //   error = true;
      // }
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_shoot.stop();
    m_intake.stop();
    // m_lime.lightOff();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return System.currentTimeMillis() >= m_endtime || error;
  }
}
