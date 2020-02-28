/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class SpinCommand extends CommandBase {
  /**
   * Creates a new SpinCommand.
   * 
   */
  ShooterSubsystem shoot;
  // IntakeSubsystem pull;
  //private VictorSPX top1;
  //private VictorSPX top2;
  private int m_one;
  private int m_two;
  
  public SpinCommand(ShooterSubsystem shooter, int motor1, int motor2) {
    // Use addRequirements() here to declare subsystem dependencies.
    shoot = shooter;
    m_one = motor1;
    m_two = motor2;
    addRequirements(shooter);
  }
  // public SpinCommand(IntakeSubsystem pulling, int motor1, int motor2){
  //   pull = pulling;
  //   m_one = motor1;
  //   m_two = motor2;
  //   addRequirements(pulling);
  // }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //top1 =    new VictorSPX(m_one);
    //top2 = new VictorSPX(m_two);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_one != 9){
      shoot.top1.set  (VictorSPXControlMode.PercentOutput, .9);
      shoot.top2.set  (VictorSPXControlMode.PercentOutput, .9);
    }else{
      shoot.top1.set  (VictorSPXControlMode.PercentOutput, -.9);
      shoot.top2.set  (VictorSPXControlMode.PercentOutput, .9);
   }
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
