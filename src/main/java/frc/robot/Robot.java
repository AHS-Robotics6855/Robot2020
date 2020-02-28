/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.InitSpinCommand;
import frc.robot.commands.RevSpin;
import frc.robot.commands.SpinCommand;
import frc.robot.commands.StopMotorCommand;
import frc.robot.subsystems.ColorSpinSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.RevIntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.commands.ArcadeDrive;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private Command m_autonomousCommand;
  private RobotContainer m_robotContainer;

  private ColorSpinSubsystem spin;

  public static ShooterSubsystem shoot;
  public static Joystick stick;
  public static Joystick stick2;
  public static DriveTrainSubsystem drive;
  //public static IntakeSubsystem intake;
  public static RevIntakeSubsystem rev;
  

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();

    //Joysticks
    stick = new Joystick(0);
    stick2 = new Joystick(1);

    //Buttons
    JoystickButton b_intake = new JoystickButton(stick2, 1);
    JoystickButton b_reverse_intake = new JoystickButton(stick2, 3);
    JoystickButton b_fire = new JoystickButton(stick, 1);
    

    spin = new ColorSpinSubsystem();

    drive = new DriveTrainSubsystem();
    drive.setDefaultCommand(new ArcadeDrive(drive));

    shoot = new ShooterSubsystem();
    b_fire.whenPressed(new SpinCommand(shoot, 10, 6));
    b_fire.whenReleased(new StopMotorCommand(shoot, 10, 6));

    //intake = new IntakeSubsystem();
    //intake = new IntakeSubsystem();
    //b_reverse_intake.whenPressed(new IntakeCommand(intake));
    //b_reverse_intake.whenReleased(new StopMotorCommand(intake, 9, 7));

    //b_reverse_intake.whenPressed(new SpinCommand(intake, 9, 7));
    //b_reverse_intake.whenReleased(new StopMotorCommand(intake, 9, 7));

    rev = new RevIntakeSubsystem();
    b_intake.whenPressed(new RevSpin(rev, 1));
    b_intake.whenReleased(new StopMotorCommand(rev, 9, 7));
    b_reverse_intake.whenPressed(new RevSpin(rev, -1));
    b_reverse_intake.whenReleased(new StopMotorCommand(rev, 9, 7));

  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {

  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {

  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
