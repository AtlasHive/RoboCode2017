package org.usfirst.frc.team5633;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    /** Joystick Port **/
    public static final int joystickPort = 0;
    public static final int joystickSpeedAxis = 3;
    public static final double joystickTwistScale = 0.75d;
    public static boolean joystickSquaredInputs = true;
    
    public static final int Left_SPEEDCONTROLLER = 9;
    public static final int Right_SPEEDCONTROLLER = 8;
    public static final boolean Left_Reverse = true;
    public static final boolean Right_Reverse = true;

    public static final int Sweep_SPEEDCONTROLLER = 1;
    public static final int Hopper_SPEEDCONTROLLER = 2; // Spark
    public static final int Climber_SPEEDCONTROLLER = 3; // Spark
    public static final int Shooter_SPEEDCONTROLLER = 4;

    public static final int Sweepin_BUTTON = 5;
    public static final int Sweepout_BUTTON = 3;
    public static final int StartShoot_BUTTON = 11;
    public static final int StopShoot_BUTTON = 12;
    public static final int Hopper_BUTTON = 1;
    public static final int ClimbUp_BUTTON = 6;
    public static final int ClimbDown_BUTTON = 4;

    public static Talon driveLeftController, driveRightController, shooterController, sweepController;
    public static Spark climberController, hopperController;

}
