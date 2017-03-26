package org.usfirst.frc.team5633.subsystems;

import org.usfirst.frc.team5633.Robot;
import org.usfirst.frc.team5633.RobotMap;
import org.usfirst.frc.team5633.commands.DriveInTeleop;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrainSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    protected RobotDrive mRobotDrive;

    public void initDefaultCommand() {
	// Set the default command for a subsystem.
	setDefaultCommand(new DriveInTeleop());

    }

    public DriveTrainSubsystem(RobotDrive robotDrive) {
	mRobotDrive = robotDrive;
    }

    public void jinput(Joystick stick) {
	/**
	 * Takes the scaled input of stick axis RobotMap.joystickSpeedAxis and multiplies it by the stick y axis
	 * 
	 * Takes RobotMap.joystickTwistScale of the stick twist axis
	 */
	Robot.robotDrive.arcadeDrive(-(stick.getY() * ((stick.getRawAxis(RobotMap.joystickSpeedAxis) + 1.0d) / 2.0d)),
		-RobotMap.joystickTwistScale * stick.getTwist(), RobotMap.joystickSquaredInputs);

    }
}
