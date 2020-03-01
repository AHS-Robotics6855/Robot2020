/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LimeLightSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.TargetGoal;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  //private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final Command m_autoCommand = null;
  
  //Subsystems
  private DriveTrainSubsystem m_driveSub = new DriveTrainSubsystem();
  private ShooterSubsystem m_shooterSub = new ShooterSubsystem();
  private IntakeSubsystem m_intakeSub = new IntakeSubsystem();
  private LimeLightSubsystem m_limeSub = new LimeLightSubsystem();
  
  //Joysticks
  private Joystick stick;
  private Joystick stick2;

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    //Joysticks
    stick = new Joystick(0);
    stick2 = new Joystick(1);
    
    //Buttons
    JoystickButton b_intake = new JoystickButton(stick2, 1);
    JoystickButton b_reverse_intake = new JoystickButton(stick2, 3);
    JoystickButton b_fire = new JoystickButton(stick, 1);
    JoystickButton b_target_goal = new JoystickButton(stick, 2);

    //Drive
    
    m_driveSub.setDefaultCommand(new ArcadeDrive(m_driveSub, stick));


    //Intake
    b_intake.whenPressed(m_intakeSub::spinForward, m_intakeSub);
    b_intake.whenReleased(m_intakeSub::stop, m_intakeSub);
    b_reverse_intake.whenPressed(m_intakeSub::spinBackward, m_intakeSub);
    b_reverse_intake.whenReleased(m_intakeSub::stop, m_intakeSub);

    //Shooter
    b_fire.whenPressed(m_shooterSub::shoot, m_shooterSub);
    b_fire.whenReleased(m_shooterSub::stop, m_shooterSub);

    //Limelight
    b_target_goal.whileHeld(new TargetGoal(m_limeSub, m_driveSub, b_target_goal));
 
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
