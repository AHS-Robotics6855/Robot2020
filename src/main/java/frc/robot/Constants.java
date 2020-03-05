/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Color spin motor (CAN Spark)
    public static final int COLOR_SPIN_MOTOR_ID = 12;

    //Joystick axis
    public static final int JOYSTICK_X = 0;
    public static final int JOYSTICK_Y = 1;
    public static final int JOYSTICK_Z = 2;

    //DriveTrain Motors (CAN Spark)
    public static final int DRIVE_Motor_ID = 2;  //Left  front
    public static final int DRIVE_Motor_ID2 = 3; //Left  back
    public static final int DRIVE_Motor_ID3 = 4; //Right front
    public static final int DRIVE_Motor_ID4 = 5; //Right back

    //Intake
    public static final int INTAKE_1 = 6;
    public static final int INTAKE_2 = 9;
    public static final int INTAKE_ROLLER = 11;

    //Shooter
    public static final int SHOOTER_1 = 8;
    public static final int SHOOTER_2 = 7;

    //Pneumatics Motors

    //Lift
    public static final int LIFT = 10;
    public static final int WINCH = 13;
    public static final int LIMIT = 0;
}
