/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class ShooterSubsystem extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
//  SpeedController m_top, m_bottom;

  public VictorSPX top1;
  public VictorSPX top2;

  public ShooterSubsystem(){

    top1 =    new VictorSPX(10);
    top2 =    new VictorSPX(6);
    
    //SpeedController leftside = new SpeedControllerGroup(top1, bottom1);
    //SpeedController rightside = new SpeedControllerGroup(top2, bottom2);

    //shootdrive = new DifferentialDrive(leftside,rightside);
  }

  @Override
  public void periodic() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    //setDefaultCommand(new ShootCommand(Robot.shoot));
  }

}
