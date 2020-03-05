/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.subsystems.ColorSpinSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LiftSubsystem;
import frc.robot.subsystems.LimeLightSubsystem;
import frc.robot.subsystems.PneumaticsSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.AutoShoot;
import frc.robot.commands.TimedTank;
import frc.robot.commands.TimedTargetGoal;
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
  
  
  //Subsystems
  private DriveTrainSubsystem m_driveSub = new DriveTrainSubsystem();
  private ShooterSubsystem m_shooterSub = new ShooterSubsystem();
  private IntakeSubsystem m_intakeSub = new IntakeSubsystem();
  private LimeLightSubsystem m_limeSub = new LimeLightSubsystem();
  private PneumaticsSubsystem m_pneuSub = new PneumaticsSubsystem();
  private ColorSpinSubsystem m_spinSub = new ColorSpinSubsystem();
  private LiftSubsystem m_liftSub = new LiftSubsystem();
  
  private final Command m_autoCommand = new SequentialCommandGroup(
    new TimedTank(m_driveSub,  0.4,  0.4, 2000),
    new TimedTargetGoal(m_limeSub, m_driveSub, 3000),
    new AutoShoot(m_shooterSub, m_intakeSub, m_limeSub, 15000)
  );
  //DriveStraightForXatYCommand();
  
  //Joysticks
  private Joystick stick;
  private Joystick stick2;

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    CameraServer.getInstance().startAutomaticCapture().setResolution(320, 240);
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
    JoystickButton b_reverse_intake = new JoystickButton(stick2, 2);
    JoystickButton b_fire = new JoystickButton(stick, 1);
    JoystickButton b_target_goal = new JoystickButton(stick, 2);
    JoystickButton b_intake_pneu_open = new JoystickButton(stick2, 3);
    JoystickButton b_intake_pneu_close = new JoystickButton(stick2, 4);
    JoystickButton b_color_red = new JoystickButton(stick2, 5); 
    JoystickButton b_color_blue = new JoystickButton(stick2, 6); 
    JoystickButton b_color_green = new JoystickButton(stick2, 7); 
    JoystickButton b_color_yellow = new JoystickButton(stick2, 8);
    JoystickButton b_spin = new JoystickButton(stick2, 9);    
    POVButton b_spin_open = new POVButton(stick2, 180);
    POVButton b_spin_close = new POVButton(stick2, 0);
    // POVButton b_front_SpinF = new POVButton(stick2, 90);
    // POVButton b_front_SpinB = new POVButton(stick2, 270);
    JoystickButton b_winch = new JoystickButton(stick, 8);
    // POVButton b_extend = new POVButton(stick, 0);
    // POVButton b_extend_reverse = new POVButton(stick, 180);
    JoystickButton b_extend = new JoystickButton(stick, 3);
    JoystickButton b_extend_reverse = new JoystickButton(stick, 4);

    //Drive
    m_driveSub.setDefaultCommand(new ArcadeDrive(m_driveSub, stick));

    //Intaked
    b_intake.whenPressed(m_intakeSub::spinForward, m_intakeSub);
    b_intake.whenReleased(m_intakeSub::stop, m_intakeSub);
    b_reverse_intake.whenPressed(m_intakeSub::spinBackward, m_intakeSub);
    b_reverse_intake.whenReleased(m_intakeSub::stop, m_intakeSub);

    //Shooter
    b_fire.whenPressed(m_shooterSub::shoot, m_shooterSub);
    b_fire.whenReleased(m_shooterSub::stop, m_shooterSub);

    //Limelight
    b_target_goal.whileHeld(new TargetGoal(m_limeSub, m_driveSub, b_target_goal));
    
    //Pneumatics
    b_intake_pneu_open.whenPressed(m_pneuSub::intakeOpen, m_pneuSub);
    b_intake_pneu_close.whenPressed(m_pneuSub::intakeClose, m_pneuSub);

    b_spin_open.whenPressed(m_pneuSub::spinOpen, m_pneuSub);
    b_spin_close.whenPressed(m_pneuSub::spinClose, m_pneuSub);

    //ColorSpinner
    b_spin.whenPressed(m_spinSub::spin, m_spinSub);
    b_spin.whenReleased(m_spinSub::spinOff, m_spinSub);
    b_color_green.whenPressed(m_spinSub::selectColorG, m_spinSub);
    b_color_blue.whenPressed(m_spinSub::selectColorB, m_spinSub);
    b_color_red.whenPressed(m_spinSub::selectColorR, m_spinSub);
    b_color_yellow.whenPressed(m_spinSub::selectColorY, m_spinSub);

    //Lift
    b_winch.whenPressed(m_liftSub::winchWind, m_liftSub);
    b_extend.whileHeld(m_liftSub::extUp, m_liftSub);
    b_extend.whenReleased(m_liftSub::extStop, m_liftSub);

    b_winch.whenReleased(m_liftSub::winchWindOff, m_liftSub);
    b_extend_reverse.whenPressed(m_liftSub::extBack, m_liftSub);
    b_extend_reverse.whenReleased(m_liftSub::extStop, m_liftSub);
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
