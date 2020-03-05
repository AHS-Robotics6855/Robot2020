/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;


public class LimeLightSubsystem extends SubsystemBase {

  private NetworkTable m_limelightTable;
  private NetworkTableEntry tx;
  private NetworkTableEntry ty;
  private NetworkTableEntry ta;

  public LimeLightSubsystem() {
    m_limelightTable = NetworkTableInstance.getDefault().getTable("limelight");
    tx = m_limelightTable.getEntry("tx");
    ty = m_limelightTable.getEntry("ty");
    ta = m_limelightTable.getEntry("ta");
    lightOff();
  }

  public void lightOff()
  {
    m_limelightTable.getEntry("ledMode").setNumber(1);
  }

  public void lightOn()
  {
    m_limelightTable.getEntry("ledMode").setNumber(3);
  }

  public double getAngleX()
  {
    return tx.getDouble(0.0);
  }

  public double getAngleY()
  {
    return ty.getDouble(0.0);
  }

  public double getArea()
  {
    return ta.getDouble(0.0);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("LimelightX", getAngleX());
    SmartDashboard.putNumber("LimelightY", getAngleY());
    SmartDashboard.putNumber("LimelightArea", getArea());
  }

}
